(ns game.board-square-test
  (:require [clojure.test :refer :all]
            [game.colors :refer :all]
            [game.board-square :refer :all]))

(deftest test-square?-18
  (let [square-18 (square 18)]
  
    (testing "should know the id of the square"
      (is (= (:id square-18) 18)))

    (testing "should know the color of the square"
      (is (= (:color square-18) (:black colors))))

    (testing "should know the north vector of the square"
      (is (= (:north (:dirs square-18)) [26 34 42 50 58])))
    (testing "should know the north-east vector of the square"
      (is (= (:north-east (:dirs square-18)) [27 36 45 54 63])))
    (testing "should know the east vector of the square"
      (is (= (:east (:dirs square-18)) [19 20 21 22 23])))
    (testing "should know the south-east vector of the square"
      (is (= (:south-east (:dirs square-18)) [11 4])))
    (testing "should know the south vector of the square"
      (is (= (:south (:dirs square-18)) [10 2])))
    (testing "should know the south-west vector of the square"
      (is (= (:south-west (:dirs square-18)) [9 0])))
    (testing "should know the west vector of the square"
      (is (= (:west (:dirs square-18)) [17 16])))
    (testing "should know the north-west vector of the square"
      (is (= (:north-west (:dirs square-18)) [25 32])))
    ))
