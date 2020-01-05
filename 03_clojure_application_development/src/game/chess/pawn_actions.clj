(ns game.chess.pawn-actions
  (:require
    [game.board :refer [get-vector]]
    [game.board-coordinates :refer [get-row-num]]
    [game.chess.piece-action-map :refer [merge-maps]]
    [game.chess.friend-or-foe :refer [add-friend-or-foe]]
    [game.chess.pieces-on-board :refer [square-occupied square-empty pieces-on-board]]
    ))

(def move-map {
  :white :north-1-square
  :black :south-1-square
  })

(def move-2-map {
  :white :north-2-squares
  :black :south-2-squares
  })

(def attack-left-map {
  :white :north-west-1-square
  :black :south-west-1-square
  })

(def attack-right-map {
  :white :north-east-1-square
  :black :south-east-1-square
  })

(def base-row-map {
  :white 1
  :black 6
  })

(defn- on-base-row [s c]
  (= (get-row-num s) (c base-row-map)))

(defn- square-num [s d]
  (first (get-vector s d)))

(defn- last-square-num [s d]
  (last (get-vector s d)))

(defn- square [fn s c m]
  (fn s (c m)))

(defn pawn-actions [s c b]
  (let [
    action-map {}

    move (square square-num s c move-map)
    move-2 (square last-square-num s c move-2-map)
    attack-left (square square-num s c attack-left-map)
    attack-right (square square-num s c attack-right-map)

    can-move-1 (if (square-empty move b) true false)
    two-squares-open (if (and can-move-1 (square-empty move-2 b)) true false)
    can-move-2 (if (and (on-base-row s c) two-squares-open) true false)

    action-map (if can-move-1
      (assoc action-map :moves [move])
      action-map)

    action-map (if can-move-2
      (merge-maps action-map (assoc action-map :moves [move-2]))
      action-map)

    action-map (if (square-occupied attack-left b)
      (add-friend-or-foe attack-left c action-map b)
      action-map)

    action-map (if (square-occupied attack-right b)
      (add-friend-or-foe attack-right c action-map b)
      action-map)
    ]
  action-map))
