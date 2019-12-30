(ns game.board-test
  (:require [clojure.test :refer :all]
            [clojure.core :refer :all]
            [game.board :refer :all]))

(def test-board (board))

(deftest board-size
  (testing "should have non-zero size")
    (is (= (count test-board) 64)))
