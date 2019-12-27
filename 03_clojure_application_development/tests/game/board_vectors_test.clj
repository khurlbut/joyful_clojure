(ns game.board-vectors-test
  (:require [clojure.test :refer :all]
            [game.board-vectors :refer :all]))

(deftest test-get-vector-east
  (testing "should return vector [19 20 21 22 23] for square 18"
    (is (= (get-vector-east 18) [19 20 21 22 23])))
  (testing "should return vector [19] for square 18"
    (is (= (get-vector-east 18 1) [19])))
  (testing "should return vector [19 20] for square 18"
    (is (= (get-vector-east 18 2) [19 20])))
)

(deftest test-get-vector-west
  (testing "should return vector [17 16] for square 18"
    (is (= (get-vector-west 18) [17 16])))
  (testing "should return vector [17] for square 18"
    (is (= (get-vector-west 18 1) [17])))
  (testing "should return vector [17 16] for square 18"
    (is (= (get-vector-west 18 2) [17 16])))
)

(deftest test-get-vector-north
  (testing "should return vector [26 34 42 50 58] for square 18"
    (is (= (get-vector-north 18) [26 34 42 50 58])))
  (testing "should return vector [26] for square 18"
    (is (= (get-vector-north 18 1) [26])))
  (testing "should return vector [26 34] for square 18"
    (is (= (get-vector-north 18 2) [26 34])))
)

(deftest test-get-vector-south
  (testing "should return vector [10 2] for square 18"
    (is (= (get-vector-south 18) [10 2])))
  (testing "should return vector [10] for square 18"
    (is (= (get-vector-south 18 1) [10])))
  (testing "should return vector [10 2] for square 18"
    (is (= (get-vector-south 18 2) [10 2])))
)

(deftest test-get-vector-north-east
  (testing "should return vector [27 36 45 54 63] for square 18"
    (is (= (get-vector-north-east 18) [27 36 45 54 63])))
  (testing "should return vector [27] for square 18"
    (is (= (get-vector-north-east 18 1) [27])))
  (testing "should return vector [27 36] for square 18"
    (is (= (get-vector-north-east 18 2) [27 36])))
)

(deftest test-get-vector-north-west
  (testing "should return vector [25 32] for square 18"
    (is (= (get-vector-north-west 18) [25 32])))
  (testing "should return vector [25] for square 18"
    (is (= (get-vector-north-west 18 1) [25])))
  (testing "should return vector [27 36] for square 18"
    (is (= (get-vector-north-west 18 2) [25 32])))
)

(deftest test-get-vector-south-east
  (testing "should return vector [11 4] for square 18"
    (is (= (get-vector-south-east 18) [11 4])))
  (testing "should return vector [19] for square 18"
    (is (= (get-vector-south-east 18 1) [11])))
  (testing "should return vector [11 4] for square 18"
    (is (= (get-vector-south-east 18 2) [11 4])))
)


(deftest test-get-vector-south-west
  (testing "should return vector [9 0] for square 18"
    (is (= (get-vector-south-west 18) [9 0])))
  (testing "should return vector [9] for square 18"
    (is (= (get-vector-south-west 18 1) [9])))
  (testing "should return vector [9 0] for square 18"
    (is (= (get-vector-south-west 18 2) [9 0])))
)

(deftest test-all-game-board-vectors
    (test-get-vector-east)
    (test-get-vector-west)
    (test-get-vector-north)
    (test-get-vector-south)
    (test-get-vector-north-east)
    (test-get-vector-north-west)
    (test-get-vector-south-east)
    (test-get-vector-south-west)
)
