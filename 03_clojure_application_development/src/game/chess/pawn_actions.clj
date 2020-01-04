(ns game.chess.pawn-actions
  (:require
    [game.board :refer [get-vector]]
    [game.chess.friend-or-foe :refer [add-friend-or-foe]]
    [game.chess.pieces-on-board :refer [square-occupied square-empty]]
    ))

(defn pawn-actions [s c b]
  (let [
    action-map {}

    north-1 (first (get-vector s :north-1-square))
    south-1 (first (get-vector s :south-1-square))
    north-2 (last (get-vector s :north-2-squares))
    south-2 (last (get-vector s :south-2-squares))

    attack-left-north (first (get-vector s :north-west-1-square))
    attack-left-south (first (get-vector s :south-west-1-square))
    attack-right-north (first (get-vector s :north-east-1-square))
    attack-right-south (first (get-vector s :south-east-1-square))

    forward-1 (if (= :white c) north-1 south-1)
    forward-2 (if (= :white c) north-2 south-2)
    attack-left (if (= :white c) attack-left-north attack-left-south)
    attack-right (if (= :white c) attack-right-north attack-right-south)

    action-map (if (square-empty forward-1 b)
      (assoc action-map :moves [forward-1])
      action-map)
    action-map (if (square-occupied attack-left b)
      (add-friend-or-foe attack-left c action-map b)
      action-map)
    action-map (if (square-occupied attack-right b)
      (add-friend-or-foe attack-right c action-map b)
      action-map)
  ]
  ; (println "forward-1: " forward-1)
  ; (println "forward-2: " forward-2)
  ; (println "attack-left: " attack-left)
  ; (println "attack-right: " attack-right)
  action-map))