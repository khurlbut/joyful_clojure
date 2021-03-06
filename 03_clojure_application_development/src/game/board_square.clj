(ns game.board-square
  (:require
    [game.board-square-color :refer [shifted-color]]
    [game.board-vectors :refer :all]
    ))

(defn square [s]
  (let [
    sq {
      :id s
      :color (shifted-color s)
      :dirs {
        :north (get-vector-north s)
        :south (get-vector-south s)
        :east  (get-vector-east  s)
        :west  (get-vector-west  s)

        :north-east (get-vector-north-east s)
        :north-west (get-vector-north-west s)
        :south-east (get-vector-south-east s)
        :south-west (get-vector-south-west s)

        :north-1-square (get-vector-north s 1)
        :south-1-square (get-vector-south s 1)
        :east-1-square  (get-vector-east  s 1)
        :west-1-square  (get-vector-west  s 1)

        :north-east-1-square (get-vector-north-east s 1)
        :north-west-1-square (get-vector-north-west s 1)
        :south-east-1-square (get-vector-south-east s 1)
        :south-west-1-square (get-vector-south-west s 1)

        :north-2-squares (get-vector-north s 2)
        :south-2-squares (get-vector-south s 2)
        :east-2-squares  (get-vector-east s 2)
        :west-2-squares  (get-vector-west s 2)
      }
    }
  ]
  sq)
)
