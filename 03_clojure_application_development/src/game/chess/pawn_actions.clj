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

(defn- on-base-row [s c] (= (get-row-num s) (c base-row-map)))
(defn- square-num [s d] (first (get-vector s d)))
(defn- last-square-num [s d] (last (get-vector s d)))
(defn- square [f s c m] (f s (c m)))
(defn- move [s c] (square square-num s c move-map))
(defn- move-2 [s c]  (square last-square-num s c move-2-map))
(defn- attack-left [s c] (square square-num s c attack-left-map))
(defn- attack-right [s c] (square square-num s c attack-right-map))

(defn- can-move [s c b] (square-empty (move s c) b))
(defn- two-squares-open [s c b] (and (can-move s c b) (square-empty move-2 b)))
(defn- can-move-2 [s c b] (and (on-base-row s c) (two-squares-open s c b)))
(defn- can-attack-left [s c b] (square-occupied (attack-left s c) b))
(defn- can-attack-right [s c b] (square-occupied (attack-right s c) b))

(defn- build-moves-map [s c b]
  (let [
    m (if (can-move s c b) (assoc {} :moves [(move s c)]) {})
    m (if (can-move-2 s c b) (merge-maps m (assoc m :moves [(move-2 s c)])) m)
  ]
  m))

(defn pawn-actions [s c b]
  (let [
    actions-map (build-moves-map s c b)

    actions-map (if (can-attack-left s c b)
      (add-friend-or-foe (attack-left s c) c actions-map b)
      actions-map)

    actions-map (if (can-attack-right s c b)
      (add-friend-or-foe (attack-right s c) c actions-map b)
      actions-map)
    ]
  actions-map))
