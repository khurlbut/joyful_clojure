(ns game.board-test
  (:require [clojure.test :refer :all]
            [game.board-dimensions :refer :all]
            [game.board :refer :all]))

(deftest test-board-size
  (testing "should have non-zero size")
    (is (= (count game-board) max-board-squares)))

(deftest test-get-square-from-board
  (testing "should return square 0")
    (is (= (:id (get-board-square 0)) 0))
  (testing "should return square 0")
    (is (= (:id (get-board-square 7)) 7))
  (testing "should return square 0")
    (is (= (:id (get-board-square 56)) 56))
  (testing "should return square 0")
    (is (= (:id (get-board-square 63)) 63))
)
