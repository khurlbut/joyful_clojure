(ns game.board-test
  (:require [clojure.test :refer :all]
            [game.board :refer :all]
            [middleware.error-handling]))

(deftest test-get-square
  (testing "should return the 0if 0 is requested square"
    (is (= (get-square 0) 0)))
  (testing "should return the 63 if 63 is requested square"
    (is (= (get-square 63) 63)))
  (testing "should return nil if requested square is out-of-bounds(< 0)"
    (is (= (get-square -1) nil)))
  (testing "should return nil if requested square is out-of-bounds (> 63)"
    (is (= (get-square 64) nil)))
)

(deftest test-get-row-num
  (testing "square in row 0 should return 0"
    (is (= (get-row-num 4) 0)))
  (testing "square in row 2 should return 2"
    (is (= (get-row-num 18) 2)))
  (testing "square in row 7 should return 7"
    (is (= (get-row-num 60) 7)))
)

(deftest test-get-col-num
  (testing "square 4 is position 4 in row"
    (is (= (get-col-num 4) 4)))
  (testing "square 61 is postion 5 in row"
    (is (= (get-col-num 61) 5)))
  (testing "square 18 is postion 2 in row"
    (is (= (get-col-num 18) 2)))
)

(deftest test-get-row-vector-from-base-square
  (testing "should return vector for square 0"
    (is (= (get-row-vector 0) [0 1 2 3 4 5 6 7])))
  (testing "should return vector for square 8"
    (is (= (get-row-vector 8) [8 9 10 11 12 13 14 15])))
  (testing "should return vector for square 16"
    (is (= (get-row-vector 16) [16 17 18 19 20 21 22 23])))
  (testing "should return vector for square 24"
    (is (= (get-row-vector 24) [24 25 26 27 28 29 30 31])))
  (testing "should return vector for square 32"
    (is (= (get-row-vector 32) [32 33 34 35 36 37 38 39])))
  (testing "should return vector for square 40"
    (is (= (get-row-vector 40) [40 41 42 43 44 45 46 47])))
  (testing "should return vector for square 48"
    (is (= (get-row-vector 48) [48 49 50 51 52 53 54 55])))
  (testing "should return vector for square 56"
    (is (= (get-row-vector 56) [56 57 58 59 60 61 62 63])))
)

(deftest test-get-row-vector-from-random-square
  (testing "should return vector for square 0"
    (is (= (get-row-vector 1) [0 1 2 3 4 5 6 7])))
  (testing "should return vector for square 8"
    (is (= (get-row-vector 10) [8 9 10 11 12 13 14 15])))
  (testing "should return vector for square 16"
    (is (= (get-row-vector 18) [16 17 18 19 20 21 22 23])))
  (testing "should return vector for square 24"
    (is (= (get-row-vector 27) [24 25 26 27 28 29 30 31])))
  (testing "should return vector for square 32"
    (is (= (get-row-vector 36) [32 33 34 35 36 37 38 39])))
  (testing "should return vector for square 40"
    (is (= (get-row-vector 45) [40 41 42 43 44 45 46 47])))
  (testing "should return vector for square 48"
    (is (= (get-row-vector 54) [48 49 50 51 52 53 54 55])))
  (testing "should return vector for square 63"
    (is (= (get-row-vector 63) [56 57 58 59 60 61 62 63])))
)

(deftest test-get-col-vector-from-base-square
  (testing "should return vector for square 0"
    (is (= (get-col-vector 0) [0 8 16 24 32 40 48 56])))
  (testing "should return vector for square 1"
    (is (= (get-col-vector 1) [1 9 17 25 33 41 49 57])))
  (testing "should return vector for square 2"
    (is (= (get-col-vector 2) [2 10 18 26 34 42 50 58])))
  (testing "should return vector for square 3"
    (is (= (get-col-vector 3) [3 11 19 27 35 43 51 59])))
  (testing "should return vector for square 4"
    (is (= (get-col-vector 4) [4 12 20 28 36 44 52 60])))
  (testing "should return vector for square 5"
    (is (= (get-col-vector 5) [5 13 21 29 37 45 53 61])))
  (testing "should return vector for square 6"
    (is (= (get-col-vector 6) [6 14 22 30 38 46 54 62])))
  (testing "should return vector for square 7"
    (is (= (get-col-vector 7) [7 15 23 31 39 47 55 63])))
)

(deftest test-get-col-vector-from-random-square
  (testing "should return vector for square 0"
    (is (= (get-col-vector 8) [0 8 16 24 32 40 48 56])))
  (testing "should return vector for square 1"
    (is (= (get-col-vector 17) [1 9 17 25 33 41 49 57])))
  (testing "should return vector for square 2"
    (is (= (get-col-vector 26) [2 10 18 26 34 42 50 58])))
  (testing "should return vector for square 3"
    (is (= (get-col-vector 35) [3 11 19 27 35 43 51 59])))
  (testing "should return vector for square 4"
    (is (= (get-col-vector 44) [4 12 20 28 36 44 52 60])))
  (testing "should return vector for square 5"
    (is (= (get-col-vector 53) [5 13 21 29 37 45 53 61])))
  (testing "should return vector for square 6"
    (is (= (get-col-vector 62) [6 14 22 30 38 46 54 62])))
  (testing "should return vector for square 7"
    (is (= (get-col-vector 47) [7 15 23 31 39 47 55 63])))
)

(deftest test-vectors-east
  (testing "should return vector [19 20 21 22 23] for square 18"
    (is (= (get-vector-east 18) [18 19 20 21 22 23])))
)

(deftest test-all-game-board
    (test-get-row-num)
    (test-get-col-num)
    (test-get-row-vector-from-base-square)
    (test-get-row-vector-from-random-square)
    (test-get-col-vector-from-base-square)
    (test-get-col-vector-from-random-square)
)
