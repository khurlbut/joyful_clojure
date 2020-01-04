(ns game.chess.actions
  (:require [game.chess.actions_foundation :refer :all]
            [game.board :refer [get-board-square]]
            [game.chess.pieces-on-board :refer :all]))

(defn rook-actions [s c b]
  (let [
    north (build-action-map (get-vector s :north) c b)
    south (build-action-map (get-vector s :south) c b)
    east  (build-action-map (get-vector s :east)  c b)
    west  (build-action-map (get-vector s :west)  c b)
  ]
  (reduce merge-maps [north south east west])))

(defn bishop-actions [s c b]
  (let [
    north-east (build-action-map (get-vector s :north-east) c b)
    north-west (build-action-map (get-vector s :north-west) c b)
    south-east (build-action-map (get-vector s :south-east) c b)
    south-west (build-action-map (get-vector s :south-west) c b)
  ]
  (reduce merge-maps [north-east north-west south-east south-west])))

(defn queen-actions [s c b]
  (let [
    north      (build-action-map (get-vector s :north)      c b)
    south      (build-action-map (get-vector s :south)      c b)
    east       (build-action-map (get-vector s :east)       c b)
    west       (build-action-map (get-vector s :west)       c b)
    north-east (build-action-map (get-vector s :north-east) c b)
    north-west (build-action-map (get-vector s :north-west) c b)
    south-east (build-action-map (get-vector s :south-east) c b)
    south-west (build-action-map (get-vector s :south-west) c b)
  ]
  (reduce merge-maps
    [north south east west north-east north-west south-east south-west])))

(defn king-actions [s c b]
  (let [
    north      (build-action-map (get-vector s :north-1-square)      c b)
    south      (build-action-map (get-vector s :south-1-square)      c b)
    east       (build-action-map (get-vector s :east-1-square)       c b)
    west       (build-action-map (get-vector s :west-1-square)       c b)
    north-east (build-action-map (get-vector s :north-east-1-square) c b)
    north-west (build-action-map (get-vector s :north-west-1-square) c b)
    south-east (build-action-map (get-vector s :south-east-1-square) c b)
    south-west (build-action-map (get-vector s :south-west-1-square) c b)
  ]
  (reduce merge-maps
    [north south east west north-east north-west south-east south-west])))

(defn knight-actions [s c b]
  (let [
    north-bend (last (get-vector s :north-2-squares))
    south-bend (last (get-vector s :south-2-squares))
    east-bend (last (get-vector  s :east-2-squares))
    west-bend (last (get-vector  s :west-2-squares))

    n-n-e (build-action-map (get-vector north-bend :east-1-square)  c b)
    n-n-w (build-action-map (get-vector north-bend :west-1-square)  c b)
    s-s-e (build-action-map (get-vector south-bend :east-1-square)  c b)
    s-s-w (build-action-map (get-vector south-bend :west-1-square)  c b)
    e-e-n (build-action-map (get-vector east-bend  :north-1-square) c b)
    e-e-s (build-action-map (get-vector east-bend  :south-1-square) c b)
    w-w-n (build-action-map (get-vector west-bend  :north-1-square) c b)
    w-w-s (build-action-map (get-vector west-bend  :south-1-square) c b)
  ]
  (reduce merge-maps
    [n-n-e, n-n-w, s-s-e, s-s-w, e-e-n, e-e-s, w-w-n, w-w-s])))

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

    action-map (if (not (square-occupied forward-1 b))
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
