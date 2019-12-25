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

(deftest test-get-south-east-diag-vector
  (testing "should return vector for square 0"
    (is (= (get-south-east-diag-vector 0) [0])))

  (testing "should return vector for square 1"
    (is (= (get-south-east-diag-vector 1) [8 1])))
  (testing "should return vector for square 8"
    (is (= (get-south-east-diag-vector 8) [8 1])))

  (testing "should return vector for square 2"
    (is (= (get-south-east-diag-vector 2) [16 9 2])))
  (testing "should return vector for square 9"
    (is (= (get-south-east-diag-vector 9) [16 9 2])))
  (testing "should return vector for square 16"
    (is (= (get-south-east-diag-vector 16) [16 9 2])))

  (testing "should return vector for square 3"
    (is (= (get-south-east-diag-vector 3) [24 17 10 3])))
  (testing "should return vector for square 10"
    (is (= (get-south-east-diag-vector 10) [24 17 10 3])))
  (testing "should return vector for square 17"
    (is (= (get-south-east-diag-vector 17) [24 17 10 3])))
  (testing "should return vector for square 24"
    (is (= (get-south-east-diag-vector 24) [24 17 10 3])))

  (testing "should return vector for square 4"
    (is (= (get-south-east-diag-vector 4) [32 25 18 11 4])))
  (testing "should return vector for square 11"
    (is (= (get-south-east-diag-vector 11) [32 25 18 11 4])))
  (testing "should return vector for square 18"
    (is (= (get-south-east-diag-vector 18) [32 25 18 11 4])))
  (testing "should return vector for square 25"
    (is (= (get-south-east-diag-vector 25) [32 25 18 11 4])))
  (testing "should return vector for square 32"
    (is (= (get-south-east-diag-vector 32) [32 25 18 11 4])))

  (testing "should return vector for square 5"
    (is (= (get-south-east-diag-vector 5) [40 33 26 19 12 5])))
  (testing "should return vector for square 12"
    (is (= (get-south-east-diag-vector 12) [40 33 26 19 12 5])))
  (testing "should return vector for square 19"
    (is (= (get-south-east-diag-vector 19) [40 33 26 19 12 5])))
  (testing "should return vector for square 26"
    (is (= (get-south-east-diag-vector 26) [40 33 26 19 12 5])))
  (testing "should return vector for square 33"
    (is (= (get-south-east-diag-vector 33) [40 33 26 19 12 5])))
  (testing "should return vector for square 40"
    (is (= (get-south-east-diag-vector 40) [40 33 26 19 12 5])))

  (testing "should return vector for square 6"
    (is (= (get-south-east-diag-vector 6) [48 41 34 27 20 13 6])))
  (testing "should return vector for square 13"
    (is (= (get-south-east-diag-vector 13) [48 41 34 27 20 13 6])))
  (testing "should return vector for square 20"
    (is (= (get-south-east-diag-vector 20) [48 41 34 27 20 13 6])))
  (testing "should return vector for square 27"
    (is (= (get-south-east-diag-vector 27) [48 41 34 27 20 13 6])))
  (testing "should return vector for square 34"
    (is (= (get-south-east-diag-vector 34) [48 41 34 27 20 13 6])))
  (testing "should return vector for square 41"
    (is (= (get-south-east-diag-vector 41) [48 41 34 27 20 13 6])))
  (testing "should return vector for square 48"
    (is (= (get-south-east-diag-vector 48) [48 41 34 27 20 13 6])))

  (testing "should return vector for square 7"
    (is (= (get-south-east-diag-vector 7) [56 49 42 35 28 21 14 7])))
  (testing "should return vector for square 14"
    (is (= (get-south-east-diag-vector 14) [56 49 42 35 28 21 14 7])))
  (testing "should return vector for square 21"
    (is (= (get-south-east-diag-vector 21) [56 49 42 35 28 21 14 7])))
  (testing "should return vector for square 28"
    (is (= (get-south-east-diag-vector 28) [56 49 42 35 28 21 14 7])))
  (testing "should return vector for square 35"
    (is (= (get-south-east-diag-vector 35) [56 49 42 35 28 21 14 7])))
  (testing "should return vector for square 42"
    (is (= (get-south-east-diag-vector 42) [56 49 42 35 28 21 14 7])))
  (testing "should return vector for square 49"
    (is (= (get-south-east-diag-vector 49) [56 49 42 35 28 21 14 7])))
  (testing "should return vector for square 56"
    (is (= (get-south-east-diag-vector 56) [56 49 42 35 28 21 14 7])))

  (testing "should return vector for square 15"
    (is (= (get-south-east-diag-vector 15) [57 50 43 36 29 22 15])))
  (testing "should return vector for square 22"
    (is (= (get-south-east-diag-vector 22) [57 50 43 36 29 22 15])))
  (testing "should return vector for square 29"
    (is (= (get-south-east-diag-vector 29) [57 50 43 36 29 22 15])))
  (testing "should return vector for square 36"
    (is (= (get-south-east-diag-vector 36) [57 50 43 36 29 22 15])))
  (testing "should return vector for square 43"
    (is (= (get-south-east-diag-vector 43) [57 50 43 36 29 22 15])))
  (testing "should return vector for square 50"
    (is (= (get-south-east-diag-vector 50) [57 50 43 36 29 22 15])))
  (testing "should return vector for square 57"
    (is (= (get-south-east-diag-vector 57) [57 50 43 36 29 22 15])))

  (testing "should return vector for square 23"
    (is (= (get-south-east-diag-vector 23) [58 51 44 37 30 23])))
  (testing "should return vector for square 30"
    (is (= (get-south-east-diag-vector 30) [58 51 44 37 30 23])))
  (testing "should return vector for square 37"
    (is (= (get-south-east-diag-vector 37) [58 51 44 37 30 23])))
  (testing "should return vector for square 44"
    (is (= (get-south-east-diag-vector 44) [58 51 44 37 30 23])))
  (testing "should return vector for square 51"
    (is (= (get-south-east-diag-vector 51) [58 51 44 37 30 23])))
  (testing "should return vector for square 58"
    (is (= (get-south-east-diag-vector 58) [58 51 44 37 30 23])))

  (testing "should return vector for square 31"
    (is (= (get-south-east-diag-vector 31) [59 52 45 38 31])))
  (testing "should return vector for square 38"
    (is (= (get-south-east-diag-vector 38) [59 52 45 38 31])))
  (testing "should return vector for square 45"
    (is (= (get-south-east-diag-vector 45) [59 52 45 38 31])))
  (testing "should return vector for square 52"
    (is (= (get-south-east-diag-vector 52) [59 52 45 38 31])))
  (testing "should return vector for square 59"
    (is (= (get-south-east-diag-vector 59) [59 52 45 38 31])))

  (testing "should return vector for square 39"
    (is (= (get-south-east-diag-vector 39) [60 53 46 39])))
  (testing "should return vector for square 46"
    (is (= (get-south-east-diag-vector 46) [60 53 46 39])))
  (testing "should return vector for square 53"
    (is (= (get-south-east-diag-vector 53) [60 53 46 39])))
  (testing "should return vector for square 60"
    (is (= (get-south-east-diag-vector 60) [60 53 46 39])))

  (testing "should return vector for square 47"
    (is (= (get-south-east-diag-vector 47) [61 54 47])))
  (testing "should return vector for square 54"
    (is (= (get-south-east-diag-vector 54) [61 54 47])))
  (testing "should return vector for square 61"
    (is (= (get-south-east-diag-vector 61) [61 54 47])))

  (testing "should return vector for square 55"
    (is (= (get-south-east-diag-vector 55) [62 55])))
  (testing "should return vector for square 62"
    (is (= (get-south-east-diag-vector 62) [62 55])))

  (testing "should return vector for square 63"
    (is (= (get-south-east-diag-vector 63) [63])))
)

(deftest test-vectors-east
  (testing "should return vector [19 20 21 22 23] for square 18"
    (is (= (get-vector-east 18) [18 19 20 21 22 23])))
)

(deftest test-all-game-board
    (test-get-row-num)
    (test-get-col-num)
    (test-get-south-east-diag-num)
    (test-get-row-vector-from-base-square)
    (test-get-row-vector-from-random-square)
    (test-get-col-vector-from-base-square)
    (test-get-col-vector-from-random-square)
)
