package com.springboot.dao;

import com.springboot.domain.Question;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @classDesc: 题目 数据操作接口
 * @author: Vipin Zheng
 * @createDate: 2018-04-29 15:39:14
 * @version: v1.0
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>, JpaSpecificationExecutor<Question> {

    // jpa复杂查询语句
    public default List<Question> findByCondition(String name, Long categoryId) {
        // 1.声明结果集
        List<Question> resultList = null;
        // 2.构造查询语句
        Specification<Question> querySpec = new Specification<Question>() {
            private static final long serialVersionUID = 1L;

            /**
             *
             * @param root 代表的查询的实体类
             * @param query 可以从中得到Root对象，即告知JPA Criteria查询要查询哪一个实体类,还可以来添加查询条件，还可以结合EntityManager对象得到最终查询的TypedQuery 对象
             * @param cb 用于创建Criteria相关的对象工程，当然可以从中获取到predicate类型
             * @return 代表一个查询条件
             */
            @Override
            public Predicate toPredicate(Root<Question> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicates = new ArrayList<>();
                if (null != name && !"".equals(name)) {
                    predicates.add(cb.like(root.get("name"), "%" + name + "%"));
                }
                if (null != categoryId) {
                    predicates.add(cb.equal(root.get("category").get("id"), categoryId));
                }
                return cb.and(predicates.toArray(new Predicate[0])); // 集合转数组
            }
        };
        // 返回查询结果
        return this.findAll(querySpec);
    }

}
