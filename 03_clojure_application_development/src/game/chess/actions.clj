(ns game.chess.actions
  (:require [game.board :refer [get-board-square]]
            [game.chess.pieces-on-board :refer :all]))

(defn- add-to [l s r]
  (assoc r l (conj (l r) s))
)

(defn- friend-or-foe [s c b]
  (if (= c (:color (get-piece b s))) "friend" "foe"))

(defn- add-friend-or-foe [s c r b]
  (if (= "friend" (friend-or-foe s c b))
    (add-to :friends s r)
    (add-to :foes s r)))

(defn get-vector-data [v c b]
  (let [colr c
        board b]
  (loop [remaining v results {}]
    (if (empty? remaining)
      results
      (let [s (first remaining)]
        (if (square-occupied s board)
          (add-friend-or-foe s colr results board)
          (let [next-remaining (rest remaining)
                next-results (add-to :moves s results)]
            (recur next-remaining next-results))))))))

; (defn get-actions [vectors c b]
;   (let [colr c
;         board b]
;   (loop [remaining vectors results {}]
;     (if (empty? remaining)
;       results
;       (let [next-remaining (rest remaining)
;             next-results (get-vector-data (first remaining) colr board)]
;         (recur next-remaining next-results))))))

(defn merge-vectors-in-maps [m1 m2]
  (let [m1-moves (assoc m1 :moves (concat (:moves m1) (:moves m2)))
        m1-friends (assoc m1-moves :friends (concat (:friends m1) (:friends m2)))
        merged-map (assoc m1-friends :foes (concat (:foes m1) (:foes m2)))]
  merged-map))

(defn get-dirs-map [s]
  (:dirs (get-board-square s)))

(defn get-dir-squares [s dir]
  (get (get-dirs-map s) dir))

(defn rook-actions [s b]
  (let [N (get-dir-squares s :north)
        S (get-dir-squares s :south)
        E (get-dir-squares s :east)
        W (get-dir-squares s :west)
        north-action-map (get-vector-data N :white b)
        south-action-map (get-vector-data S :white b)
        east-action-map (get-vector-data E :white b)
        west-action-map (get-vector-data W :white b)
        ]
      (merge-vectors-in-maps north-action-map east-action-map)))
