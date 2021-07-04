package com.excellent.knowbookcore.service.impl;

import com.excellent.knowbookcommon.dao.sub.SubUsersMapper;
import com.excellent.knowbookcommon.dao.UsersMapper;
import com.excellent.knowbookcommon.model.enums.ResultEnum;
import com.excellent.knowbookcommon.model.exception.KownBookException;
import com.excellent.knowbookcommon.model.pojo.Users;
import com.excellent.knowbookcommon.model.pojo.UsersExample;
import com.excellent.knowbookcommon.repository.UsersRepository;
import com.excellent.knowbookcore.service.UsersService;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @User: Rowena
 * @Date: 2018/7/31
 * Description:
 */
@Service
public class UsersServiceImpl implements UsersService {

    private static Logger logger= LoggerFactory.getLogger(UsersServiceImpl.class);

    @Autowired
    private SubUsersMapper usersMapper;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Users> queryUsers(String  userId) throws Exception{
        if(userId==null||"".equals(userId)){
            throw new KownBookException(ResultEnum.UIDEQUALNULL);
        }
        List<Users> usersList=new ArrayList<>();
        Users users=usersMapper.selectByPrimaryKey(userId);
        usersList.add(users);
        return usersList;
    }

    @Override
    public Integer insertUser(Users users) {
        if(users.getUserName()==null){
            throw new KownBookException(ResultEnum.ERROR);
        }
        return usersMapper.insertSelective(users);
    }

    @Override
    public List<Users> selectAll() {
       return usersMapper.selectAll();

    }

    @Override
    public Users selectUserByUserId(String userId) {
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria=example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andDeteledEqualTo(0);
        List<Users> usersList=usersMapper.selectByExample(example);
        return usersList.get(0);
    }

    @Override
    public String saveUsers(Users users) {
        Users usersResult = usersRepository.save(users);
        return usersResult.getUserId();
    }

    @Override
    public List<Users> searchUsers(Integer pageNumber,
                                   Integer pageSize,
                                   String searchContent) {
        // 分页参数
        Pageable pageable = new PageRequest(pageNumber, pageSize);

        // Function Score Query
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("Username", searchContent)),
                        ScoreFunctionBuilders.weightFactorFunction(1000))
                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("description", searchContent)),
                        ScoreFunctionBuilders.weightFactorFunction(100));

        // 创建搜索 DSL 查询
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();

        logger.info("\n searchBook(): searchContent [" + searchContent + "] \n DSL  = \n " + searchQuery.getQuery().toString());

        Page<Users> searchPageResults = usersRepository.search(searchQuery);
        return searchPageResults.getContent();
    }

    @Override
    public List<Users> selectAllUsers() {
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andDeteledEqualTo(0);
        List<Users> list = usersMapper.selectByExample(example);
        if (list.size() != 0) {
            return list;
        } else {
            return null;
        }
    }


}
