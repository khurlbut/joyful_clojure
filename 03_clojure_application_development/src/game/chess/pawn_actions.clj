(ns game.chess.pawn-actions
  (:require
    [game.board :refer [get-vector]]
    [game.board-coordinates :refer [get-row-num]]
    [game.chess.piece-action-map :refer [merge-maps]]
    [game.chess.friend-or-foe :refer [add-friend-or-foe]]
    [game.chess.pieces-on-board :refer [square-occupied square-empty pieces-on-board]]
    ))

(def move-forward {
  :north :north-1-square
  :south :south-1-square
  })

(def move-forward-2 {
  :north :north-2-squares
  :south :south-2-squares
  })

(def left-attack {
  :north :north-west-1-square
  :south :south-west-1-square
  })

(def right-attack {
  :north :north-east-1-square
  :south :south-east-1-square
  })

(defn get-square-num [s d]
  (first (get-vector s d)))

(defn get-last-square-num [s d]
  (last (get-vector s d)))

(defn action-square [fn s c north-square south-square]
  (let [
    n-sq (fn s north-square)
    s-sq (fn s south-square)
    ]
  (if (= :white c) n-sq s-sq)))

(defn action-square-new [fn s c m]
  (let [
    n-sq (fn s (:north m))
    s-sq (fn s (:south m))
    ]
  (if (= :white c) n-sq s-sq)))

(defn pawn-actions [s c b]
  (let [
    action-map {}

    forward-1 (action-square-new get-square-num s c move-forward)
    forward-2 (action-square-new get-last-square-num s c move-forward-2)

    attack-left (action-square-new get-square-num s c left-attack)
    attack-right (action-square-new get-square-num s c right-attack)

    base-row (if (= :white c) 1 6)
    on-base-row (if (= (get-row-num s) base-row) true false)

    can-move-1 (if (square-empty forward-1 b) true false)
    two-squares-open (if (and can-move-1 (square-empty forward-2 b)) true false)
    can-move-2 (if (and on-base-row two-squares-open) true false)

    action-map (if can-move-1
      (assoc action-map :moves [forward-1])
      action-map)

    action-map (if can-move-2
      (merge-maps action-map (assoc action-map :moves [forward-2]))
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
  ; (println "can-move-2: " can-move-2)
  ;  (if can-move-2 (println "WORKS!"))

  action-map))
