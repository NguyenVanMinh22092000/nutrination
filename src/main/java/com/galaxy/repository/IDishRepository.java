package com.galaxy.repository;

import com.galaxy.entity.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDishRepository extends JpaRepository<Dish, Long> {
//    @Query(nativeQuery = true,
//            value = "SELECT c.brand AS brand," +
//                    " c.ram_memory AS ramMemory FROM computers c WHERE c.brand LIKE %:name%",
//            countQuery ="SELECT count(*) FROM computers c WHERE c.brand LIKE %:name%" )
////    Page<Dish> findAllComputer(Pageable pageable, @Param("name") String name);
//    List<Dish> findDishes();
//
//@Query(nativeQuery = true,
//        value = "SELECT d.id, d.calo, d.name, d.price, d.bmi_id, d.meal_id FROM dish d" +
//                " JOIN meal m ON d.meal_id = m.id" +
//                " JOIN customer c ON d.bmi_id = c.bmi_id" +
//                " WHERE c.bmi_id = 1 AND m.id = 1;",
//        countQuery = "SELECT count(*) FROM dish d" +
//                " JOIN meal m ON d.meal_id = m.id" +
//                " JOIN customer c ON d.bmi_id = c.bmi_id" +
//                " WHERE c.bmi_id = 1 AND m.id = 1;")
//List<Dish> findDishes(@Param("bmiId") Long bmiId, @Param("mealId") Long mealId);

//    @Query(nativeQuery = true,
//            value = "SELECT d.id, d.calo, d.price, d.name, d.bmi_id, d.meal_id FROM dish d" +
//                    " JOIN meal m ON d.meal_id = m.id" +
//                    " JOIN customer c ON d.bmi_id = c.bmi_id" +
//                    " WHERE c.bmi_id = 1 AND m.id = 1;",
//            countQuery = "SELECT count(*) FROM dish d" +
//                    " JOIN meal m ON d.meal_id = m.id" +
//                    " JOIN customer c ON d.bmi_id = c.bmi_id" +
//                    " WHERE c.bmi_id = :bmiId AND m.id = :mealId;")
//    List<Dish> findDishes(@Param("bmiId") Long bmiId, @Param("mealId") Long mealId);

//    @Query("SELECT d FROM Dish d " +
//            "JOIN Meal m ON m.id = d.meal.id " +
//            "JOIN Customer c ON c.bmi.id = d.bmi.id," +
//            "WHERE c.bmi.id = :bmiId AND m.id = :mealId")
//    List<Dish> findDishes(@Param("bmiId") Long bmiId, @Param("mealId") Long mealId);

//    @Query("SELECT d FROM Dish d " +
//            "JOIN Meal m ON m.id = d.meal.id" +
//            " JOIN Customer c ON c.bmi.id = d.bmi.id" +
//            "WHERE c.bmi.id= :bmiId AND m.id = :mealId")
//    List<Dish> findDishes(@Param("bmiId") Long bmiId, @Param("mealId") Long mealId);
@Query("SELECT d FROM Dish d " +
            "JOIN Meal m " +
            " JOIN Customer c " +
            "WHERE c.bmi.id= :bmiId AND m.id = :mealId")
    List<Dish> findDishes(@Param("bmiId") Long bmiId, @Param("mealId") Long mealId);


}
