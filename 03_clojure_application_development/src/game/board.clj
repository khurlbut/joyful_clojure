(ns game.board)

(def dimensions
  {
    :rows 8
    :cols 8})

(defn get-square [s]
  (cond
    (< s 0) nil
    (> s 63) nil
    :else s))

(defn get-row-num [s]
  (let [s (get-square s)
        cols (float (dimensions :cols))
        row (/ s cols)]
        (int row)))

(defn get-col-num [s]
  (let [s (get-square s)
        cols (dimensions :cols)]
  (mod s cols)))

(defn get-south-east-diag-num [s]
  (+ (get-col-num s) (get-row-num s)))

(defn get-row-vector [s]
  (let [row-num (get-row-num s)]
    (case row-num
      7 [56 57 58 59 60 61 62 63]
      6 [48 49 50 51 52 53 54 55]
      5 [40 41 42 43 44 45 46 47]
      4 [32 33 34 35 36 37 38 39]
      3 [24 25 26 27 28 29 30 31]
      2 [16 17 18 19 20 21 22 23]
      1 [ 8  9 10 11 12 13 14 15]
      0 [ 0  1  2  3  4  5  6  7]
    )))

(defn get-col-vector [s]
  (let [col-num (get-col-num s)]
    (case col-num
      0 [0  8 16 24 32 40 48 56]
      1 [1  9 17 25 33 41 49 57]
      2 [2 10 18 26 34 42 50 58]
      3 [3 11 19 27 35 43 51 59]
      4 [4 12 20 28 36 44 52 60]
      5 [5 13 21 29 37 45 53 61]
      6 [6 14 22 30 38 46 54 62]
      7 [7 15 23 31 39 47 55 63]
    )))

(defn get-south-east-diag-vector [s]
  (let [diag-num (get-south-east-diag-num s)]
    (case diag-num
      0  [0]
      1  [8 1]
      2  [16 9 2]
      3  [24 17 10 3]
      4  [32 25 18 11 4]
      5  [40 33 26 19 12 5]
      6  [48 41 34 27 20 13 6]
      7  [56 49 42 35 28 21 14 7]
      8  [57 50 43 36 29 22 15]
      9  [58 51 44 37 30 23]
      10 [59 52 45 38 31]
      11 [60 53 46 39]
      12 [61 54 47]
      13 [62 55]
      14 [63]
    )))

(defn get-vector-east [num]
  (case num
    0 [1 2 3 4 5 6 7]
    8 [9 10 11 12 13 14 15]
  ))
