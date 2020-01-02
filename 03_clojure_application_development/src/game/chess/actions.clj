(ns game.chess.actions
  (:require [game.chess.actions_foundation :refer :all]
            [game.board :refer [get-board-square]]
            [game.chess.pieces-on-board :refer :all]))

(defn rook-actions [s c b]
  (let [north (build-action-map (get-vector s :north) c b)
        south (build-action-map (get-vector s :south) c b)
        east  (build-action-map (get-vector s :east)  c b)
        west  (build-action-map (get-vector s :west)  c b)]
  (reduce merge-maps [north south east west])))
