package com.excellent.knowbookcommon.model.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBookIdIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(String value) {
            addCriterion("book_id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(String value) {
            addCriterion("book_id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(String value) {
            addCriterion("book_id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(String value) {
            addCriterion("book_id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(String value) {
            addCriterion("book_id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(String value) {
            addCriterion("book_id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLike(String value) {
            addCriterion("book_id like", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotLike(String value) {
            addCriterion("book_id not like", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<String> values) {
            addCriterion("book_id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<String> values) {
            addCriterion("book_id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(String value1, String value2) {
            addCriterion("book_id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(String value1, String value2) {
            addCriterion("book_id not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNull() {
            addCriterion("book_name is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("book_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("book_name =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("book_name <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("book_name >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("book_name >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("book_name <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("book_name <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("book_name like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("book_name not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("book_name in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("book_name not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("book_name between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("book_name not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookInfoIsNull() {
            addCriterion("book_info is null");
            return (Criteria) this;
        }

        public Criteria andBookInfoIsNotNull() {
            addCriterion("book_info is not null");
            return (Criteria) this;
        }

        public Criteria andBookInfoEqualTo(String value) {
            addCriterion("book_info =", value, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoNotEqualTo(String value) {
            addCriterion("book_info <>", value, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoGreaterThan(String value) {
            addCriterion("book_info >", value, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoGreaterThanOrEqualTo(String value) {
            addCriterion("book_info >=", value, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoLessThan(String value) {
            addCriterion("book_info <", value, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoLessThanOrEqualTo(String value) {
            addCriterion("book_info <=", value, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoLike(String value) {
            addCriterion("book_info like", value, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoNotLike(String value) {
            addCriterion("book_info not like", value, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoIn(List<String> values) {
            addCriterion("book_info in", values, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoNotIn(List<String> values) {
            addCriterion("book_info not in", values, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoBetween(String value1, String value2) {
            addCriterion("book_info between", value1, value2, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoNotBetween(String value1, String value2) {
            addCriterion("book_info not between", value1, value2, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIsNull() {
            addCriterion("book_author is null");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIsNotNull() {
            addCriterion("book_author is not null");
            return (Criteria) this;
        }

        public Criteria andBookAuthorEqualTo(String value) {
            addCriterion("book_author =", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotEqualTo(String value) {
            addCriterion("book_author <>", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorGreaterThan(String value) {
            addCriterion("book_author >", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("book_author >=", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLessThan(String value) {
            addCriterion("book_author <", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLessThanOrEqualTo(String value) {
            addCriterion("book_author <=", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLike(String value) {
            addCriterion("book_author like", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotLike(String value) {
            addCriterion("book_author not like", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIn(List<String> values) {
            addCriterion("book_author in", values, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotIn(List<String> values) {
            addCriterion("book_author not in", values, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorBetween(String value1, String value2) {
            addCriterion("book_author between", value1, value2, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotBetween(String value1, String value2) {
            addCriterion("book_author not between", value1, value2, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookQualityIsNull() {
            addCriterion("book_quality is null");
            return (Criteria) this;
        }

        public Criteria andBookQualityIsNotNull() {
            addCriterion("book_quality is not null");
            return (Criteria) this;
        }

        public Criteria andBookQualityEqualTo(String value) {
            addCriterion("book_quality =", value, "bookQuality");
            return (Criteria) this;
        }

        public Criteria andBookQualityNotEqualTo(String value) {
            addCriterion("book_quality <>", value, "bookQuality");
            return (Criteria) this;
        }

        public Criteria andBookQualityGreaterThan(String value) {
            addCriterion("book_quality >", value, "bookQuality");
            return (Criteria) this;
        }

        public Criteria andBookQualityGreaterThanOrEqualTo(String value) {
            addCriterion("book_quality >=", value, "bookQuality");
            return (Criteria) this;
        }

        public Criteria andBookQualityLessThan(String value) {
            addCriterion("book_quality <", value, "bookQuality");
            return (Criteria) this;
        }

        public Criteria andBookQualityLessThanOrEqualTo(String value) {
            addCriterion("book_quality <=", value, "bookQuality");
            return (Criteria) this;
        }

        public Criteria andBookQualityLike(String value) {
            addCriterion("book_quality like", value, "bookQuality");
            return (Criteria) this;
        }

        public Criteria andBookQualityNotLike(String value) {
            addCriterion("book_quality not like", value, "bookQuality");
            return (Criteria) this;
        }

        public Criteria andBookQualityIn(List<String> values) {
            addCriterion("book_quality in", values, "bookQuality");
            return (Criteria) this;
        }

        public Criteria andBookQualityNotIn(List<String> values) {
            addCriterion("book_quality not in", values, "bookQuality");
            return (Criteria) this;
        }

        public Criteria andBookQualityBetween(String value1, String value2) {
            addCriterion("book_quality between", value1, value2, "bookQuality");
            return (Criteria) this;
        }

        public Criteria andBookQualityNotBetween(String value1, String value2) {
            addCriterion("book_quality not between", value1, value2, "bookQuality");
            return (Criteria) this;
        }

        public Criteria andBookPressIsNull() {
            addCriterion("book_Press is null");
            return (Criteria) this;
        }

        public Criteria andBookPressIsNotNull() {
            addCriterion("book_Press is not null");
            return (Criteria) this;
        }

        public Criteria andBookPressEqualTo(String value) {
            addCriterion("book_Press =", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressNotEqualTo(String value) {
            addCriterion("book_Press <>", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressGreaterThan(String value) {
            addCriterion("book_Press >", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressGreaterThanOrEqualTo(String value) {
            addCriterion("book_Press >=", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressLessThan(String value) {
            addCriterion("book_Press <", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressLessThanOrEqualTo(String value) {
            addCriterion("book_Press <=", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressLike(String value) {
            addCriterion("book_Press like", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressNotLike(String value) {
            addCriterion("book_Press not like", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressIn(List<String> values) {
            addCriterion("book_Press in", values, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressNotIn(List<String> values) {
            addCriterion("book_Press not in", values, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressBetween(String value1, String value2) {
            addCriterion("book_Press between", value1, value2, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressNotBetween(String value1, String value2) {
            addCriterion("book_Press not between", value1, value2, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookBeforePriceIsNull() {
            addCriterion("book_before_price is null");
            return (Criteria) this;
        }

        public Criteria andBookBeforePriceIsNotNull() {
            addCriterion("book_before_price is not null");
            return (Criteria) this;
        }

        public Criteria andBookBeforePriceEqualTo(Double value) {
            addCriterion("book_before_price =", value, "bookBeforePrice");
            return (Criteria) this;
        }

        public Criteria andBookBeforePriceNotEqualTo(Double value) {
            addCriterion("book_before_price <>", value, "bookBeforePrice");
            return (Criteria) this;
        }

        public Criteria andBookBeforePriceGreaterThan(Double value) {
            addCriterion("book_before_price >", value, "bookBeforePrice");
            return (Criteria) this;
        }

        public Criteria andBookBeforePriceGreaterThanOrEqualTo(Double value) {
            addCriterion("book_before_price >=", value, "bookBeforePrice");
            return (Criteria) this;
        }

        public Criteria andBookBeforePriceLessThan(Double value) {
            addCriterion("book_before_price <", value, "bookBeforePrice");
            return (Criteria) this;
        }

        public Criteria andBookBeforePriceLessThanOrEqualTo(Double value) {
            addCriterion("book_before_price <=", value, "bookBeforePrice");
            return (Criteria) this;
        }

        public Criteria andBookBeforePriceIn(List<Double> values) {
            addCriterion("book_before_price in", values, "bookBeforePrice");
            return (Criteria) this;
        }

        public Criteria andBookBeforePriceNotIn(List<Double> values) {
            addCriterion("book_before_price not in", values, "bookBeforePrice");
            return (Criteria) this;
        }

        public Criteria andBookBeforePriceBetween(Double value1, Double value2) {
            addCriterion("book_before_price between", value1, value2, "bookBeforePrice");
            return (Criteria) this;
        }

        public Criteria andBookBeforePriceNotBetween(Double value1, Double value2) {
            addCriterion("book_before_price not between", value1, value2, "bookBeforePrice");
            return (Criteria) this;
        }

        public Criteria andBookNowPriceIsNull() {
            addCriterion("book_now_price is null");
            return (Criteria) this;
        }

        public Criteria andBookNowPriceIsNotNull() {
            addCriterion("book_now_price is not null");
            return (Criteria) this;
        }

        public Criteria andBookNowPriceEqualTo(Double value) {
            addCriterion("book_now_price =", value, "bookNowPrice");
            return (Criteria) this;
        }

        public Criteria andBookNowPriceNotEqualTo(Double value) {
            addCriterion("book_now_price <>", value, "bookNowPrice");
            return (Criteria) this;
        }

        public Criteria andBookNowPriceGreaterThan(Double value) {
            addCriterion("book_now_price >", value, "bookNowPrice");
            return (Criteria) this;
        }

        public Criteria andBookNowPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("book_now_price >=", value, "bookNowPrice");
            return (Criteria) this;
        }

        public Criteria andBookNowPriceLessThan(Double value) {
            addCriterion("book_now_price <", value, "bookNowPrice");
            return (Criteria) this;
        }

        public Criteria andBookNowPriceLessThanOrEqualTo(Double value) {
            addCriterion("book_now_price <=", value, "bookNowPrice");
            return (Criteria) this;
        }

        public Criteria andBookNowPriceIn(List<Double> values) {
            addCriterion("book_now_price in", values, "bookNowPrice");
            return (Criteria) this;
        }

        public Criteria andBookNowPriceNotIn(List<Double> values) {
            addCriterion("book_now_price not in", values, "bookNowPrice");
            return (Criteria) this;
        }

        public Criteria andBookNowPriceBetween(Double value1, Double value2) {
            addCriterion("book_now_price between", value1, value2, "bookNowPrice");
            return (Criteria) this;
        }

        public Criteria andBookNowPriceNotBetween(Double value1, Double value2) {
            addCriterion("book_now_price not between", value1, value2, "bookNowPrice");
            return (Criteria) this;
        }

        public Criteria andBookPictureIsNull() {
            addCriterion("book_picture is null");
            return (Criteria) this;
        }

        public Criteria andBookPictureIsNotNull() {
            addCriterion("book_picture is not null");
            return (Criteria) this;
        }

        public Criteria andBookPictureEqualTo(String value) {
            addCriterion("book_picture =", value, "bookPicture");
            return (Criteria) this;
        }

        public Criteria andBookPictureNotEqualTo(String value) {
            addCriterion("book_picture <>", value, "bookPicture");
            return (Criteria) this;
        }

        public Criteria andBookPictureGreaterThan(String value) {
            addCriterion("book_picture >", value, "bookPicture");
            return (Criteria) this;
        }

        public Criteria andBookPictureGreaterThanOrEqualTo(String value) {
            addCriterion("book_picture >=", value, "bookPicture");
            return (Criteria) this;
        }

        public Criteria andBookPictureLessThan(String value) {
            addCriterion("book_picture <", value, "bookPicture");
            return (Criteria) this;
        }

        public Criteria andBookPictureLessThanOrEqualTo(String value) {
            addCriterion("book_picture <=", value, "bookPicture");
            return (Criteria) this;
        }

        public Criteria andBookPictureLike(String value) {
            addCriterion("book_picture like", value, "bookPicture");
            return (Criteria) this;
        }

        public Criteria andBookPictureNotLike(String value) {
            addCriterion("book_picture not like", value, "bookPicture");
            return (Criteria) this;
        }

        public Criteria andBookPictureIn(List<String> values) {
            addCriterion("book_picture in", values, "bookPicture");
            return (Criteria) this;
        }

        public Criteria andBookPictureNotIn(List<String> values) {
            addCriterion("book_picture not in", values, "bookPicture");
            return (Criteria) this;
        }

        public Criteria andBookPictureBetween(String value1, String value2) {
            addCriterion("book_picture between", value1, value2, "bookPicture");
            return (Criteria) this;
        }

        public Criteria andBookPictureNotBetween(String value1, String value2) {
            addCriterion("book_picture not between", value1, value2, "bookPicture");
            return (Criteria) this;
        }

        public Criteria andBookStyleIsNull() {
            addCriterion("book_style is null");
            return (Criteria) this;
        }

        public Criteria andBookStyleIsNotNull() {
            addCriterion("book_style is not null");
            return (Criteria) this;
        }

        public Criteria andBookStyleEqualTo(String value) {
            addCriterion("book_style =", value, "bookStyle");
            return (Criteria) this;
        }

        public Criteria andBookStyleNotEqualTo(String value) {
            addCriterion("book_style <>", value, "bookStyle");
            return (Criteria) this;
        }

        public Criteria andBookStyleGreaterThan(String value) {
            addCriterion("book_style >", value, "bookStyle");
            return (Criteria) this;
        }

        public Criteria andBookStyleGreaterThanOrEqualTo(String value) {
            addCriterion("book_style >=", value, "bookStyle");
            return (Criteria) this;
        }

        public Criteria andBookStyleLessThan(String value) {
            addCriterion("book_style <", value, "bookStyle");
            return (Criteria) this;
        }

        public Criteria andBookStyleLessThanOrEqualTo(String value) {
            addCriterion("book_style <=", value, "bookStyle");
            return (Criteria) this;
        }

        public Criteria andBookStyleLike(String value) {
            addCriterion("book_style like", value, "bookStyle");
            return (Criteria) this;
        }

        public Criteria andBookStyleNotLike(String value) {
            addCriterion("book_style not like", value, "bookStyle");
            return (Criteria) this;
        }

        public Criteria andBookStyleIn(List<String> values) {
            addCriterion("book_style in", values, "bookStyle");
            return (Criteria) this;
        }

        public Criteria andBookStyleNotIn(List<String> values) {
            addCriterion("book_style not in", values, "bookStyle");
            return (Criteria) this;
        }

        public Criteria andBookStyleBetween(String value1, String value2) {
            addCriterion("book_style between", value1, value2, "bookStyle");
            return (Criteria) this;
        }

        public Criteria andBookStyleNotBetween(String value1, String value2) {
            addCriterion("book_style not between", value1, value2, "bookStyle");
            return (Criteria) this;
        }

        public Criteria andBookThemeIsNull() {
            addCriterion("book_theme is null");
            return (Criteria) this;
        }

        public Criteria andBookThemeIsNotNull() {
            addCriterion("book_theme is not null");
            return (Criteria) this;
        }

        public Criteria andBookThemeEqualTo(String value) {
            addCriterion("book_theme =", value, "bookTheme");
            return (Criteria) this;
        }

        public Criteria andBookThemeNotEqualTo(String value) {
            addCriterion("book_theme <>", value, "bookTheme");
            return (Criteria) this;
        }

        public Criteria andBookThemeGreaterThan(String value) {
            addCriterion("book_theme >", value, "bookTheme");
            return (Criteria) this;
        }

        public Criteria andBookThemeGreaterThanOrEqualTo(String value) {
            addCriterion("book_theme >=", value, "bookTheme");
            return (Criteria) this;
        }

        public Criteria andBookThemeLessThan(String value) {
            addCriterion("book_theme <", value, "bookTheme");
            return (Criteria) this;
        }

        public Criteria andBookThemeLessThanOrEqualTo(String value) {
            addCriterion("book_theme <=", value, "bookTheme");
            return (Criteria) this;
        }

        public Criteria andBookThemeLike(String value) {
            addCriterion("book_theme like", value, "bookTheme");
            return (Criteria) this;
        }

        public Criteria andBookThemeNotLike(String value) {
            addCriterion("book_theme not like", value, "bookTheme");
            return (Criteria) this;
        }

        public Criteria andBookThemeIn(List<String> values) {
            addCriterion("book_theme in", values, "bookTheme");
            return (Criteria) this;
        }

        public Criteria andBookThemeNotIn(List<String> values) {
            addCriterion("book_theme not in", values, "bookTheme");
            return (Criteria) this;
        }

        public Criteria andBookThemeBetween(String value1, String value2) {
            addCriterion("book_theme between", value1, value2, "bookTheme");
            return (Criteria) this;
        }

        public Criteria andBookThemeNotBetween(String value1, String value2) {
            addCriterion("book_theme not between", value1, value2, "bookTheme");
            return (Criteria) this;
        }

        public Criteria andBookLanguageIsNull() {
            addCriterion("book_language is null");
            return (Criteria) this;
        }

        public Criteria andBookLanguageIsNotNull() {
            addCriterion("book_language is not null");
            return (Criteria) this;
        }

        public Criteria andBookLanguageEqualTo(String value) {
            addCriterion("book_language =", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageNotEqualTo(String value) {
            addCriterion("book_language <>", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageGreaterThan(String value) {
            addCriterion("book_language >", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("book_language >=", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageLessThan(String value) {
            addCriterion("book_language <", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageLessThanOrEqualTo(String value) {
            addCriterion("book_language <=", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageLike(String value) {
            addCriterion("book_language like", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageNotLike(String value) {
            addCriterion("book_language not like", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageIn(List<String> values) {
            addCriterion("book_language in", values, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageNotIn(List<String> values) {
            addCriterion("book_language not in", values, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageBetween(String value1, String value2) {
            addCriterion("book_language between", value1, value2, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageNotBetween(String value1, String value2) {
            addCriterion("book_language not between", value1, value2, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookRemarksIsNull() {
            addCriterion("book_remarks is null");
            return (Criteria) this;
        }

        public Criteria andBookRemarksIsNotNull() {
            addCriterion("book_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andBookRemarksEqualTo(String value) {
            addCriterion("book_remarks =", value, "bookRemarks");
            return (Criteria) this;
        }

        public Criteria andBookRemarksNotEqualTo(String value) {
            addCriterion("book_remarks <>", value, "bookRemarks");
            return (Criteria) this;
        }

        public Criteria andBookRemarksGreaterThan(String value) {
            addCriterion("book_remarks >", value, "bookRemarks");
            return (Criteria) this;
        }

        public Criteria andBookRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("book_remarks >=", value, "bookRemarks");
            return (Criteria) this;
        }

        public Criteria andBookRemarksLessThan(String value) {
            addCriterion("book_remarks <", value, "bookRemarks");
            return (Criteria) this;
        }

        public Criteria andBookRemarksLessThanOrEqualTo(String value) {
            addCriterion("book_remarks <=", value, "bookRemarks");
            return (Criteria) this;
        }

        public Criteria andBookRemarksLike(String value) {
            addCriterion("book_remarks like", value, "bookRemarks");
            return (Criteria) this;
        }

        public Criteria andBookRemarksNotLike(String value) {
            addCriterion("book_remarks not like", value, "bookRemarks");
            return (Criteria) this;
        }

        public Criteria andBookRemarksIn(List<String> values) {
            addCriterion("book_remarks in", values, "bookRemarks");
            return (Criteria) this;
        }

        public Criteria andBookRemarksNotIn(List<String> values) {
            addCriterion("book_remarks not in", values, "bookRemarks");
            return (Criteria) this;
        }

        public Criteria andBookRemarksBetween(String value1, String value2) {
            addCriterion("book_remarks between", value1, value2, "bookRemarks");
            return (Criteria) this;
        }

        public Criteria andBookRemarksNotBetween(String value1, String value2) {
            addCriterion("book_remarks not between", value1, value2, "bookRemarks");
            return (Criteria) this;
        }

        public Criteria andBookIsSellIsNull() {
            addCriterion("book_is_sell is null");
            return (Criteria) this;
        }

        public Criteria andBookIsSellIsNotNull() {
            addCriterion("book_is_sell is not null");
            return (Criteria) this;
        }

        public Criteria andBookIsSellEqualTo(Integer value) {
            addCriterion("book_is_sell =", value, "bookIsSell");
            return (Criteria) this;
        }

        public Criteria andBookIsSellNotEqualTo(Integer value) {
            addCriterion("book_is_sell <>", value, "bookIsSell");
            return (Criteria) this;
        }

        public Criteria andBookIsSellGreaterThan(Integer value) {
            addCriterion("book_is_sell >", value, "bookIsSell");
            return (Criteria) this;
        }

        public Criteria andBookIsSellGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_is_sell >=", value, "bookIsSell");
            return (Criteria) this;
        }

        public Criteria andBookIsSellLessThan(Integer value) {
            addCriterion("book_is_sell <", value, "bookIsSell");
            return (Criteria) this;
        }

        public Criteria andBookIsSellLessThanOrEqualTo(Integer value) {
            addCriterion("book_is_sell <=", value, "bookIsSell");
            return (Criteria) this;
        }

        public Criteria andBookIsSellIn(List<Integer> values) {
            addCriterion("book_is_sell in", values, "bookIsSell");
            return (Criteria) this;
        }

        public Criteria andBookIsSellNotIn(List<Integer> values) {
            addCriterion("book_is_sell not in", values, "bookIsSell");
            return (Criteria) this;
        }

        public Criteria andBookIsSellBetween(Integer value1, Integer value2) {
            addCriterion("book_is_sell between", value1, value2, "bookIsSell");
            return (Criteria) this;
        }

        public Criteria andBookIsSellNotBetween(Integer value1, Integer value2) {
            addCriterion("book_is_sell not between", value1, value2, "bookIsSell");
            return (Criteria) this;
        }

        public Criteria andCollectionCountIsNull() {
            addCriterion("collection_count is null");
            return (Criteria) this;
        }

        public Criteria andCollectionCountIsNotNull() {
            addCriterion("collection_count is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionCountEqualTo(Integer value) {
            addCriterion("collection_count =", value, "collectionCount");
            return (Criteria) this;
        }

        public Criteria andCollectionCountNotEqualTo(Integer value) {
            addCriterion("collection_count <>", value, "collectionCount");
            return (Criteria) this;
        }

        public Criteria andCollectionCountGreaterThan(Integer value) {
            addCriterion("collection_count >", value, "collectionCount");
            return (Criteria) this;
        }

        public Criteria andCollectionCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("collection_count >=", value, "collectionCount");
            return (Criteria) this;
        }

        public Criteria andCollectionCountLessThan(Integer value) {
            addCriterion("collection_count <", value, "collectionCount");
            return (Criteria) this;
        }

        public Criteria andCollectionCountLessThanOrEqualTo(Integer value) {
            addCriterion("collection_count <=", value, "collectionCount");
            return (Criteria) this;
        }

        public Criteria andCollectionCountIn(List<Integer> values) {
            addCriterion("collection_count in", values, "collectionCount");
            return (Criteria) this;
        }

        public Criteria andCollectionCountNotIn(List<Integer> values) {
            addCriterion("collection_count not in", values, "collectionCount");
            return (Criteria) this;
        }

        public Criteria andCollectionCountBetween(Integer value1, Integer value2) {
            addCriterion("collection_count between", value1, value2, "collectionCount");
            return (Criteria) this;
        }

        public Criteria andCollectionCountNotBetween(Integer value1, Integer value2) {
            addCriterion("collection_count not between", value1, value2, "collectionCount");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andDeteledIsNull() {
            addCriterion("deteled is null");
            return (Criteria) this;
        }

        public Criteria andDeteledIsNotNull() {
            addCriterion("deteled is not null");
            return (Criteria) this;
        }

        public Criteria andDeteledEqualTo(Integer value) {
            addCriterion("deteled =", value, "deteled");
            return (Criteria) this;
        }

        public Criteria andDeteledNotEqualTo(Integer value) {
            addCriterion("deteled <>", value, "deteled");
            return (Criteria) this;
        }

        public Criteria andDeteledGreaterThan(Integer value) {
            addCriterion("deteled >", value, "deteled");
            return (Criteria) this;
        }

        public Criteria andDeteledGreaterThanOrEqualTo(Integer value) {
            addCriterion("deteled >=", value, "deteled");
            return (Criteria) this;
        }

        public Criteria andDeteledLessThan(Integer value) {
            addCriterion("deteled <", value, "deteled");
            return (Criteria) this;
        }

        public Criteria andDeteledLessThanOrEqualTo(Integer value) {
            addCriterion("deteled <=", value, "deteled");
            return (Criteria) this;
        }

        public Criteria andDeteledIn(List<Integer> values) {
            addCriterion("deteled in", values, "deteled");
            return (Criteria) this;
        }

        public Criteria andDeteledNotIn(List<Integer> values) {
            addCriterion("deteled not in", values, "deteled");
            return (Criteria) this;
        }

        public Criteria andDeteledBetween(Integer value1, Integer value2) {
            addCriterion("deteled between", value1, value2, "deteled");
            return (Criteria) this;
        }

        public Criteria andDeteledNotBetween(Integer value1, Integer value2) {
            addCriterion("deteled not between", value1, value2, "deteled");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}