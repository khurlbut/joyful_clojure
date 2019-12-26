(ns game.board-test
  (:require [clojure.test :refer :all]
            [game.board :refer :all]))

(deftest test-get-square
  (testing "should return  0 if  0 is requested square"
    (is (= (get-square 0) 0)))
  (testing "should return 63 if 63 is requested square"
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
  (testing "square in row 0 col 4 should return 4"
    (is (= (get-col-num 4) 4)))
  (testing "square in row 7 col 5 should return 5"
    (is (= (get-col-num 61) 5)))
  (testing "square in row 3 col 2 should return 2"
    (is (= (get-col-num 18) 2)))
)

(deftest test-get-south-east-diag-num
  (testing "square in row 0 col 0 should return 0"
    (is (= (get-south-east-diag-num 0) 0)))

  (testing "square in row 0 col 1 should return 1"
    (is (= (get-south-east-diag-num 1) 1)))
  (testing "square in row 1 col 0 should return 1"
    (is (= (get-south-east-diag-num 8) 1)))

  (testing "square in row 0 col 2 should return 2"
    (is (= (get-south-east-diag-num 2) 2)))
  (testing "square in row 1 col 1 should return 2"
    (is (= (get-south-east-diag-num 9) 2)))
  (testing "square in row 2 col 0 should return 2"
    (is (= (get-south-east-diag-num 16) 2)))

  (testing "square in row 0 col 3 should return 3"
    (is (= (get-south-east-diag-num 3) 3)))
  (testing "square in row 1 col 2 should return 3"
    (is (= (get-south-east-diag-num 10) 3)))
  (testing "square in row 2 col 1 should return 3"
    (is (= (get-south-east-diag-num 17) 3)))
  (testing "square in row 3 col 0 should return 3"
    (is (= (get-south-east-diag-num 24) 3)))

  (testing "square in row 0 col 4 should return 4"
    (is (= (get-south-east-diag-num 4) 4)))
  (testing "square in row 1 col 3 should return 4"
    (is (= (get-south-east-diag-num 11) 4)))
  (testing "square in row 2 col 2 should return 4"
    (is (= (get-south-east-diag-num 18) 4)))
  (testing "square in row 3 col 1 should return 4"
    (is (= (get-south-east-diag-num 25) 4)))
  (testing "square in row 4 col 0 should return 4"
    (is (= (get-south-east-diag-num 32) 4)))

  (testing "square in row 0 col 5 should return 5"
    (is (= (get-south-east-diag-num 5) 5)))
  (testing "square in row 1 col 4 should return 5"
    (is (= (get-south-east-diag-num 12) 5)))
  (testing "square in row 2 col 3 should return 5"
    (is (= (get-south-east-diag-num 19) 5)))
  (testing "square in row 3 col 2 should return 5"
    (is (= (get-south-east-diag-num 26) 5)))
  (testing "square in row 4 col 1 should return 5"
    (is (= (get-south-east-diag-num 33) 5)))
  (testing "square in row 5 col 0 should return 5"
    (is (= (get-south-east-diag-num 40) 5)))

  (testing "square in row 0 col 6 should return 6"
    (is (= (get-south-east-diag-num 6) 6)))
  (testing "square in row 1 col 5 should return 6"
    (is (= (get-south-east-diag-num 13) 6)))
  (testing "square in row 2 col 4 should return 6"
    (is (= (get-south-east-diag-num 20) 6)))
  (testing "square in row 3 col 3 should return 6"
    (is (= (get-south-east-diag-num 27) 6)))
  (testing "square in row 4 col 2 should return 6"
    (is (= (get-south-east-diag-num 34) 6)))
  (testing "square in row 5 col 1 should return 6"
    (is (= (get-south-east-diag-num 41) 6)))
  (testing "square in row 6 col 0 should return 6"
    (is (= (get-south-east-diag-num 48) 6)))

  (testing "square in row 0 col 7 should return 7"
    (is (= (get-south-east-diag-num 7) 7)))
  (testing "square in row 1 col 6 should return 7"
    (is (= (get-south-east-diag-num 14) 7)))
  (testing "square in row 2 col 5 should return 7"
    (is (= (get-south-east-diag-num 21) 7)))
  (testing "square in row 3 col 4 should return 7"
    (is (= (get-south-east-diag-num 28) 7)))
  (testing "square in row 4 col 3 should return 7"
    (is (= (get-south-east-diag-num 35) 7)))
  (testing "square in row 5 col 2 should return 7"
    (is (= (get-south-east-diag-num 42) 7)))
  (testing "square in row 6 col 1 should return 7"
    (is (= (get-south-east-diag-num 49) 7)))
  (testing "square in row 7 col 0 should return 7"
    (is (= (get-south-east-diag-num 56) 7)))

  (testing "square in row 1 col 7 should return 8"
    (is (= (get-south-east-diag-num 15) 8)))
  (testing "square in row 2 col 6 should return 8"
    (is (= (get-south-east-diag-num 22) 8)))
  (testing "square in row 3 col 5 should return 8"
    (is (= (get-south-east-diag-num 29) 8)))
  (testing "square in row 4 col 4 should return 8"
    (is (= (get-south-east-diag-num 36) 8)))
  (testing "square in row 5 col 3 should return 8"
    (is (= (get-south-east-diag-num 43) 8)))
  (testing "square in row 6 col 2 should return 8"
    (is (= (get-south-east-diag-num 50) 8)))
  (testing "square in row 7 col 1 should return 8"
    (is (= (get-south-east-diag-num 57) 8)))

  (testing "square in row 2 col 7 should return 9"
    (is (= (get-south-east-diag-num 23) 9)))
  (testing "square in row 3 col 6 should return 9"
    (is (= (get-south-east-diag-num 30) 9)))
  (testing "square in row 4 col 5 should return 9"
    (is (= (get-south-east-diag-num 37) 9)))
  (testing "square in row 5 col 4 should return 9"
    (is (= (get-south-east-diag-num 44) 9)))
  (testing "square in row 6 col 3 should return 9"
    (is (= (get-south-east-diag-num 51) 9)))
  (testing "square in row 7 col 2 should return 9"
    (is (= (get-south-east-diag-num 58) 9)))

  (testing "square in row 3 col 7 should return 10"
    (is (= (get-south-east-diag-num 31) 10)))
  (testing "square in row 4 col 6 should return 10"
    (is (= (get-south-east-diag-num 38) 10)))
  (testing "square in row 5 col 5 should return 10"
    (is (= (get-south-east-diag-num 45) 10)))
  (testing "square in row 6 col 4 should return 10"
    (is (= (get-south-east-diag-num 52) 10)))
  (testing "square in row 7 col 3 should return 10"
    (is (= (get-south-east-diag-num 59) 10)))

  (testing "square in row 4 col 7 should return 11"
    (is (= (get-south-east-diag-num 39) 11)))
  (testing "square in row 5 col 6 should return 11"
    (is (= (get-south-east-diag-num 46) 11)))
  (testing "square in row 6 col 5 should return 11"
    (is (= (get-south-east-diag-num 53) 11)))
  (testing "square in row 7 col 4 should return 11"
    (is (= (get-south-east-diag-num 60) 11)))

  (testing "square in row 5 col 7 should return 12"
    (is (= (get-south-east-diag-num 47) 12)))
  (testing "square in row 6 col 6 should return 12"
    (is (= (get-south-east-diag-num 54) 12)))
  (testing "square in row 7 col 5 should return 12"
    (is (= (get-south-east-diag-num 61) 12)))

  (testing "square in row 6 col 7 should return 13"
    (is (= (get-south-east-diag-num 55) 13)))
  (testing "square in row 7 col 6 should return 13"
    (is (= (get-south-east-diag-num 62) 13)))

  (testing "square in row 7 col 7 should return 14"
    (is (= (get-south-east-diag-num 63) 14)))
)

(deftest test-get-south-west-diag-num
  (testing "square in row 0 col 7 should return 7"
    (is (= (get-south-west-diag-num 7) 7)))

  (testing "square in row 0 col 6 should return 6"
    (is (= (get-south-west-diag-num 6) 6)))
  (testing "square in row 1 col 7 should return 6"
    (is (= (get-south-west-diag-num 15) 6)))

  (testing "square in row 0 col 5 should return 5"
    (is (= (get-south-west-diag-num 5) 5)))
  (testing "square in row 1 col 6 should return 5"
    (is (= (get-south-west-diag-num 14) 5)))
  (testing "square in row 2 col 7 should return 5"
    (is (= (get-south-west-diag-num 23) 5)))

  (testing "square in row 0 col 4 should return 4"
    (is (= (get-south-west-diag-num 4) 4)))
  (testing "square in row 1 col 5 should return 4"
    (is (= (get-south-west-diag-num 13) 4)))
  (testing "square in row 2 col 6 should return 4"
    (is (= (get-south-west-diag-num 22) 4)))
  (testing "square in row 3 col 7 should return 4"
    (is (= (get-south-west-diag-num 31) 4)))

  (testing "square in row 0 col 3 should return 3"
    (is (= (get-south-west-diag-num 3) 3)))
  (testing "square in row 1 col 4 should return 3"
    (is (= (get-south-west-diag-num 12) 3)))
  (testing "square in row 2 col 5 should return 3"
    (is (= (get-south-west-diag-num 21) 3)))
  (testing "square in row 3 col 6 should return 3"
    (is (= (get-south-west-diag-num 30) 3)))
  (testing "square in row 4 col 7 should return 3"
    (is (= (get-south-west-diag-num 39) 3)))

  (testing "square in row 0 col 2 should return 2"
    (is (= (get-south-west-diag-num 2) 2)))
  (testing "square in row 1 col 3 should return 2"
    (is (= (get-south-west-diag-num 11) 2)))
  (testing "square in row 2 col 4 should return 2"
    (is (= (get-south-west-diag-num 20) 2)))
  (testing "square in row 3 col 5 should return 2"
    (is (= (get-south-west-diag-num 29) 2)))
  (testing "square in row 4 col 6 should return 2"
    (is (= (get-south-west-diag-num 38) 2)))
  (testing "square in row 5 col 7 should return 2"
    (is (= (get-south-west-diag-num 47) 2)))

  (testing "square in row 0 col 1 should return 1"
    (is (= (get-south-west-diag-num 1) 1)))
  (testing "square in row 1 col 2 should return 1"
    (is (= (get-south-west-diag-num 10) 1)))
  (testing "square in row 2 col 3 should return 1"
    (is (= (get-south-west-diag-num 19) 1)))
  (testing "square in row 3 col 4 should return 1"
    (is (= (get-south-west-diag-num 28) 1)))
  (testing "square in row 4 col 5 should return 1"
    (is (= (get-south-west-diag-num 37) 1)))
  (testing "square in row 5 col 6 should return 1"
    (is (= (get-south-west-diag-num 46) 1)))
  (testing "square in row 6 col 7 should return 1"
    (is (= (get-south-west-diag-num 55) 1)))

  (testing "square in row 0 col 0 should return 0"
    (is (= (get-south-west-diag-num 0) 0)))
  (testing "square in row 1 col 1 should return 0"
    (is (= (get-south-west-diag-num 9) 0)))
  (testing "square in row 2 col 2 should return 0"
    (is (= (get-south-west-diag-num 18) 0)))
  (testing "square in row 3 col 3 should return 0"
    (is (= (get-south-west-diag-num 27) 0)))
  (testing "square in row 4 col 4 should return 0"
    (is (= (get-south-west-diag-num 36) 0)))
  (testing "square in row 5 col 6 should return 0"
    (is (= (get-south-west-diag-num 45) 0)))
  (testing "square in row 6 col 7 should return 0"
    (is (= (get-south-west-diag-num 54) 0)))
  (testing "square in row 7 col 7 should return 0"
    (is (= (get-south-west-diag-num 63) 0)))

  (testing "square in row 1 col 0 should return -1"
    (is (= (get-south-west-diag-num 8) -1)))
  (testing "square in row 2 col 1 should return -1"
    (is (= (get-south-west-diag-num 17) -1)))
  (testing "square in row 3 col 2 should return -1"
    (is (= (get-south-west-diag-num 26) -1)))
  (testing "square in row 4 col 3 should return -1"
    (is (= (get-south-west-diag-num 35) -1)))
  (testing "square in row 5 col 4 should return -1"
    (is (= (get-south-west-diag-num 44) -1)))
  (testing "square in row 6 col 5 should return -1"
    (is (= (get-south-west-diag-num 53) -1)))
  (testing "square in row 7 col 6 should return -1"
    (is (= (get-south-west-diag-num 62) -1)))

  (testing "square in row 2 col 0 should return -2"
    (is (= (get-south-west-diag-num 16) -2)))
  (testing "square in row 3 col 1 should return -2"
    (is (= (get-south-west-diag-num 25) -2)))
  (testing "square in row 4 col 2 should return -2"
    (is (= (get-south-west-diag-num 34) -2)))
  (testing "square in row 5 col 3 should return -2"
    (is (= (get-south-west-diag-num 43) -2)))
  (testing "square in row 6 col 4 should return -2"
    (is (= (get-south-west-diag-num 52) -2)))
  (testing "square in row 7 col 5 should return -2"
    (is (= (get-south-west-diag-num 61) -2)))

  (testing "square in row 3 col 0 should return -3"
    (is (= (get-south-west-diag-num 24) -3)))
  (testing "square in row 4 col 1 should return -3"
    (is (= (get-south-west-diag-num 33) -3)))
  (testing "square in row 5 col 2 should return -3"
    (is (= (get-south-west-diag-num 42) -3)))
  (testing "square in row 6 col 3 should return -3"
    (is (= (get-south-west-diag-num 51) -3)))
  (testing "square in row 7 col 4 should return -3"
    (is (= (get-south-west-diag-num 60) -3)))

  (testing "square in row 4 col 0 should return -4"
    (is (= (get-south-west-diag-num 32) -4)))
  (testing "square in row 5 col 1 should return -4"
    (is (= (get-south-west-diag-num 41) -4)))
  (testing "square in row 6 col 2 should return -4"
    (is (= (get-south-west-diag-num 50) -4)))
  (testing "square in row 7 col 3 should return -4"
    (is (= (get-south-west-diag-num 59) -4)))

  (testing "square in row 5 col 0 should return -5"
    (is (= (get-south-west-diag-num 40) -5)))
  (testing "square in row 6 col 1 should return -5"
    (is (= (get-south-west-diag-num 49) -5)))
  (testing "square in row 7 col 2 should return -5"
    (is (= (get-south-west-diag-num 58) -5)))

  (testing "square in row 6 col 0 should return -6"
    (is (= (get-south-west-diag-num 48) -6)))
  (testing "square in row 7 col 1 should return -6"
    (is (= (get-south-west-diag-num 57) -6)))

  (testing "square in row 7 col 0 should return -7"
    (is (= (get-south-west-diag-num 56) -7)))
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

(deftest test-get-south-east-vector
  (testing "should return vector for square 0"
    (is (= (get-south-east-vector 0) [0])))

  (testing "should return vector for square 1"
    (is (= (get-south-east-vector 1) [8 1])))
  (testing "should return vector for square 8"
    (is (= (get-south-east-vector 8) [8 1])))

  (testing "should return vector for square 2"
    (is (= (get-south-east-vector 2) [16 9 2])))
  (testing "should return vector for square 9"
    (is (= (get-south-east-vector 9) [16 9 2])))
  (testing "should return vector for square 16"
    (is (= (get-south-east-vector 16) [16 9 2])))

  (testing "should return vector for square 3"
    (is (= (get-south-east-vector 3) [24 17 10 3])))
  (testing "should return vector for square 10"
    (is (= (get-south-east-vector 10) [24 17 10 3])))
  (testing "should return vector for square 17"
    (is (= (get-south-east-vector 17) [24 17 10 3])))
  (testing "should return vector for square 24"
    (is (= (get-south-east-vector 24) [24 17 10 3])))

  (testing "should return vector for square 4"
    (is (= (get-south-east-vector 4) [32 25 18 11 4])))
  (testing "should return vector for square 11"
    (is (= (get-south-east-vector 11) [32 25 18 11 4])))
  (testing "should return vector for square 18"
    (is (= (get-south-east-vector 18) [32 25 18 11 4])))
  (testing "should return vector for square 25"
    (is (= (get-south-east-vector 25) [32 25 18 11 4])))
  (testing "should return vector for square 32"
    (is (= (get-south-east-vector 32) [32 25 18 11 4])))

  (testing "should return vector for square 5"
    (is (= (get-south-east-vector 5) [40 33 26 19 12 5])))
  (testing "should return vector for square 12"
    (is (= (get-south-east-vector 12) [40 33 26 19 12 5])))
  (testing "should return vector for square 19"
    (is (= (get-south-east-vector 19) [40 33 26 19 12 5])))
  (testing "should return vector for square 26"
    (is (= (get-south-east-vector 26) [40 33 26 19 12 5])))
  (testing "should return vector for square 33"
    (is (= (get-south-east-vector 33) [40 33 26 19 12 5])))
  (testing "should return vector for square 40"
    (is (= (get-south-east-vector 40) [40 33 26 19 12 5])))

  (testing "should return vector for square 6"
    (is (= (get-south-east-vector 6) [48 41 34 27 20 13 6])))
  (testing "should return vector for square 13"
    (is (= (get-south-east-vector 13) [48 41 34 27 20 13 6])))
  (testing "should return vector for square 20"
    (is (= (get-south-east-vector 20) [48 41 34 27 20 13 6])))
  (testing "should return vector for square 27"
    (is (= (get-south-east-vector 27) [48 41 34 27 20 13 6])))
  (testing "should return vector for square 34"
    (is (= (get-south-east-vector 34) [48 41 34 27 20 13 6])))
  (testing "should return vector for square 41"
    (is (= (get-south-east-vector 41) [48 41 34 27 20 13 6])))
  (testing "should return vector for square 48"
    (is (= (get-south-east-vector 48) [48 41 34 27 20 13 6])))

  (testing "should return vector for square 7"
    (is (= (get-south-east-vector 7) [56 49 42 35 28 21 14 7])))
  (testing "should return vector for square 14"
    (is (= (get-south-east-vector 14) [56 49 42 35 28 21 14 7])))
  (testing "should return vector for square 21"
    (is (= (get-south-east-vector 21) [56 49 42 35 28 21 14 7])))
  (testing "should return vector for square 28"
    (is (= (get-south-east-vector 28) [56 49 42 35 28 21 14 7])))
  (testing "should return vector for square 35"
    (is (= (get-south-east-vector 35) [56 49 42 35 28 21 14 7])))
  (testing "should return vector for square 42"
    (is (= (get-south-east-vector 42) [56 49 42 35 28 21 14 7])))
  (testing "should return vector for square 49"
    (is (= (get-south-east-vector 49) [56 49 42 35 28 21 14 7])))
  (testing "should return vector for square 56"
    (is (= (get-south-east-vector 56) [56 49 42 35 28 21 14 7])))

  (testing "should return vector for square 15"
    (is (= (get-south-east-vector 15) [57 50 43 36 29 22 15])))
  (testing "should return vector for square 22"
    (is (= (get-south-east-vector 22) [57 50 43 36 29 22 15])))
  (testing "should return vector for square 29"
    (is (= (get-south-east-vector 29) [57 50 43 36 29 22 15])))
  (testing "should return vector for square 36"
    (is (= (get-south-east-vector 36) [57 50 43 36 29 22 15])))
  (testing "should return vector for square 43"
    (is (= (get-south-east-vector 43) [57 50 43 36 29 22 15])))
  (testing "should return vector for square 50"
    (is (= (get-south-east-vector 50) [57 50 43 36 29 22 15])))
  (testing "should return vector for square 57"
    (is (= (get-south-east-vector 57) [57 50 43 36 29 22 15])))

  (testing "should return vector for square 23"
    (is (= (get-south-east-vector 23) [58 51 44 37 30 23])))
  (testing "should return vector for square 30"
    (is (= (get-south-east-vector 30) [58 51 44 37 30 23])))
  (testing "should return vector for square 37"
    (is (= (get-south-east-vector 37) [58 51 44 37 30 23])))
  (testing "should return vector for square 44"
    (is (= (get-south-east-vector 44) [58 51 44 37 30 23])))
  (testing "should return vector for square 51"
    (is (= (get-south-east-vector 51) [58 51 44 37 30 23])))
  (testing "should return vector for square 58"
    (is (= (get-south-east-vector 58) [58 51 44 37 30 23])))

  (testing "should return vector for square 31"
    (is (= (get-south-east-vector 31) [59 52 45 38 31])))
  (testing "should return vector for square 38"
    (is (= (get-south-east-vector 38) [59 52 45 38 31])))
  (testing "should return vector for square 45"
    (is (= (get-south-east-vector 45) [59 52 45 38 31])))
  (testing "should return vector for square 52"
    (is (= (get-south-east-vector 52) [59 52 45 38 31])))
  (testing "should return vector for square 59"
    (is (= (get-south-east-vector 59) [59 52 45 38 31])))

  (testing "should return vector for square 39"
    (is (= (get-south-east-vector 39) [60 53 46 39])))
  (testing "should return vector for square 46"
    (is (= (get-south-east-vector 46) [60 53 46 39])))
  (testing "should return vector for square 53"
    (is (= (get-south-east-vector 53) [60 53 46 39])))
  (testing "should return vector for square 60"
    (is (= (get-south-east-vector 60) [60 53 46 39])))

  (testing "should return vector for square 47"
    (is (= (get-south-east-vector 47) [61 54 47])))
  (testing "should return vector for square 54"
    (is (= (get-south-east-vector 54) [61 54 47])))
  (testing "should return vector for square 61"
    (is (= (get-south-east-vector 61) [61 54 47])))

  (testing "should return vector for square 55"
    (is (= (get-south-east-vector 55) [62 55])))
  (testing "should return vector for square 62"
    (is (= (get-south-east-vector 62) [62 55])))

  (testing "should return vector for square 63"
    (is (= (get-south-east-vector 63) [63])))
)

(deftest test-get-south-west-vector
  (testing "should return vector for square 7"
    (is (= (get-south-west-vector 7) [7])))

  (testing "should return vector for square 6"
    (is (= (get-south-west-vector 6) [15 6])))
  (testing "should return vector for square 15"
    (is (= (get-south-west-vector 15) [15 6])))

  (testing "should return vector for square 5"
    (is (= (get-south-west-vector 5) [23 14 5])))
  (testing "should return vector for square 14"
    (is (= (get-south-west-vector 14) [23 14 5])))
  (testing "should return vector for square 23"
    (is (= (get-south-west-vector 23) [23 14 5])))

  (testing "should return vector for square 4"
    (is (= (get-south-west-vector 4) [31 22 13 4])))
  (testing "should return vector for square 13"
    (is (= (get-south-west-vector 13) [31 22 13 4])))
  (testing "should return vector for square 22"
    (is (= (get-south-west-vector 22) [31 22 13 4])))
  (testing "should return vector for square 31"
    (is (= (get-south-west-vector 31) [31 22 13 4])))

  (testing "should return vector for square 3"
    (is (= (get-south-west-vector 3) [39 30 21 12 3])))
  (testing "should return vector for square 12"
    (is (= (get-south-west-vector 12) [39 30 21 12 3])))
  (testing "should return vector for square 21"
    (is (= (get-south-west-vector 21) [39 30 21 12 3])))
  (testing "should return vector for square 30"
    (is (= (get-south-west-vector 30) [39 30 21 12 3])))
  (testing "should return vector for square 39"
    (is (= (get-south-west-vector 39) [39 30 21 12 3])))

  (testing "should return vector for square 2"
    (is (= (get-south-west-vector 2) [47 38 29 20 11 2])))
  (testing "should return vector for square 11"
    (is (= (get-south-west-vector 11) [47 38 29 20 11 2])))
  (testing "should return vector for square 20"
    (is (= (get-south-west-vector 20) [47 38 29 20 11 2])))
  (testing "should return vector for square 29"
    (is (= (get-south-west-vector 29) [47 38 29 20 11 2])))
  (testing "should return vector for square 38"
    (is (= (get-south-west-vector 38) [47 38 29 20 11 2])))
  (testing "should return vector for square 47"
    (is (= (get-south-west-vector 47) [47 38 29 20 11 2])))

  (testing "should return vector for square 1"
    (is (= (get-south-west-vector 1) [55 46 37 28 19 10 1])))
  (testing "should return vector for square 10"
    (is (= (get-south-west-vector 10) [55 46 37 28 19 10 1])))
  (testing "should return vector for square 19"
    (is (= (get-south-west-vector 19) [55 46 37 28 19 10 1])))
  (testing "should return vector for square 28"
    (is (= (get-south-west-vector 28) [55 46 37 28 19 10 1])))
  (testing "should return vector for square 37"
    (is (= (get-south-west-vector 37) [55 46 37 28 19 10 1])))
  (testing "should return vector for square 46"
    (is (= (get-south-west-vector 46) [55 46 37 28 19 10 1])))
  (testing "should return vector for square 55"
    (is (= (get-south-west-vector 55) [55 46 37 28 19 10 1])))

  (testing "should return vector for square 0"
    (is (= (get-south-west-vector 0) [63 54 45 36 27 18 9 0])))
  (testing "should return vector for square 9"
    (is (= (get-south-west-vector 9) [63 54 45 36 27 18 9 0])))
  (testing "should return vector for square 18"
    (is (= (get-south-west-vector 18) [63 54 45 36 27 18 9 0])))
  (testing "should return vector for square 27"
    (is (= (get-south-west-vector 27) [63 54 45 36 27 18 9 0])))
  (testing "should return vector for square 36"
    (is (= (get-south-west-vector 36) [63 54 45 36 27 18 9 0])))
  (testing "should return vector for square 45"
    (is (= (get-south-west-vector 45) [63 54 45 36 27 18 9 0])))
  (testing "should return vector for square 54"
    (is (= (get-south-west-vector 54) [63 54 45 36 27 18 9 0])))
  (testing "should return vector for square 63"
    (is (= (get-south-west-vector 63) [63 54 45 36 27 18 9 0])))

  (testing "should return vector for square 8"
    (is (= (get-south-west-vector 8) [62 53 44 35 26 17 8])))
  (testing "should return vector for square 17"
    (is (= (get-south-west-vector 17) [62 53 44 35 26 17 8])))
  (testing "should return vector for square 26"
    (is (= (get-south-west-vector 26) [62 53 44 35 26 17 8])))
  (testing "should return vector for square 35"
    (is (= (get-south-west-vector 35) [62 53 44 35 26 17 8])))
  (testing "should return vector for square 44"
    (is (= (get-south-west-vector 44) [62 53 44 35 26 17 8])))
  (testing "should return vector for square 53"
    (is (= (get-south-west-vector 53) [62 53 44 35 26 17 8])))
  (testing "should return vector for square 62"
    (is (= (get-south-west-vector 62) [62 53 44 35 26 17 8])))

  (testing "should return vector for square 16"
    (is (= (get-south-west-vector 16) [61 52 43 34 25 16])))
  (testing "should return vector for square 25"
    (is (= (get-south-west-vector 25) [61 52 43 34 25 16])))
  (testing "should return vector for square 34"
    (is (= (get-south-west-vector 34) [61 52 43 34 25 16])))
  (testing "should return vector for square 43"
    (is (= (get-south-west-vector 43) [61 52 43 34 25 16])))
  (testing "should return vector for square 52"
    (is (= (get-south-west-vector 52) [61 52 43 34 25 16])))
  (testing "should return vector for square 61"
    (is (= (get-south-west-vector 61) [61 52 43 34 25 16])))

  (testing "should return vector for square 24"
    (is (= (get-south-west-vector 24) [60 51 42 33 24])))
  (testing "should return vector for square 33"
    (is (= (get-south-west-vector 33) [60 51 42 33 24])))
  (testing "should return vector for square 42"
    (is (= (get-south-west-vector 42) [60 51 42 33 24])))
  (testing "should return vector for square 51"
    (is (= (get-south-west-vector 51) [60 51 42 33 24])))
  (testing "should return vector for square 60"
    (is (= (get-south-west-vector 60) [60 51 42 33 24])))

  (testing "should return vector for square 32"
    (is (= (get-south-west-vector 32) [59 50 41 32])))
  (testing "should return vector for square 41"
    (is (= (get-south-west-vector 41) [59 50 41 32])))
  (testing "should return vector for square 50"
    (is (= (get-south-west-vector 50) [59 50 41 32])))
  (testing "should return vector for square 59"
    (is (= (get-south-west-vector 59) [59 50 41 32])))

  (testing "should return vector for square 40"
    (is (= (get-south-west-vector 40) [58 49 40])))
  (testing "should return vector for square 49"
    (is (= (get-south-west-vector 49) [58 49 40])))
  (testing "should return vector for square 58"
    (is (= (get-south-west-vector 58) [58 49 40])))

  (testing "should return vector for square 48"
    (is (= (get-south-west-vector 48) [57 48])))
  (testing "should return vector for square 57"
    (is (= (get-south-west-vector 57) [57 48])))

  (testing "should return vector for square 56"
    (is (= (get-south-west-vector 56) [56])))
)

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

(deftest test-all-game-board
    (test-get-square)
    (test-get-row-num)
    (test-get-col-num)
    (test-get-south-east-diag-num)
    (test-get-south-west-diag-num)
    (test-get-row-vector-from-base-square)
    (test-get-row-vector-from-random-square)
    (test-get-col-vector-from-base-square)
    (test-get-col-vector-from-random-square)
    (test-get-south-east-vector)
    (test-get-south-west-vector)
    (test-get-vector-east)
    (test-get-vector-west)
    (test-get-vector-north)
    (test-get-vector-south)
    (test-get-vector-north-east)
    (test-get-vector-north-west)
    (test-get-vector-south-east)
    (test-get-vector-south-west)
)
