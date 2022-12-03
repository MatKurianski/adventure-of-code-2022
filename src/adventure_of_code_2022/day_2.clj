(ns adventure-of-code-2022.day-2
  (:require [clojure.string :as str]))

(def ^:private win-points
  6)

(def ^:private draw-points
  3)

(def ^:private loss-points
  0)

(def ^:private shapes-points
  {:rock 1
   :paper 2
   :scissors 3})

(def ^:private rounds-points
  {:rock {:rock draw-points
          :paper loss-points
          :scissors win-points}
   :paper {:rock win-points
           :paper draw-points
           :scissors loss-points}
   :scissors {:rock loss-points
              :paper win-points
              :scissors draw-points}})

(defn ^:private convert-part-1
  [hand-shape]
  (case hand-shape
    "A" :rock
    "X" :rock
    "B" :paper
    "Y" :paper
    "C" :scissors
    "Z" :scissors))

(defn ^:private calculate-points-part-1
  [acc match]
  (let [converted-match (map convert-part-1 match)
        [enemy-input my-input] converted-match
        shape-points (get shapes-points my-input)
        round-points (get-in rounds-points [my-input enemy-input])]
    (+ acc shape-points round-points)))

(defn rock-paper-scissors-part-1
  [input]
  (->> (str/split-lines input)
       (map #(str/split % #" "))
       (reduce calculate-points-part-1 0)))

(def round-result-points
  {:rock {:win (+ win-points (:paper shapes-points))
          :loss (+ loss-points (:scissors shapes-points))
          :draw (+ draw-points (:rock shapes-points))}
   :paper {:win (+ win-points (:scissors shapes-points))
          :loss (+ loss-points (:rock shapes-points))
          :draw (+ draw-points (:paper shapes-points))}
   :scissors {:win (+ win-points (:rock shapes-points))
          :loss (+ loss-points (:paper shapes-points))
          :draw (+ draw-points (:scissors shapes-points))}})

(defn ^:private convert-part-2
  [hand-shape]
  (case hand-shape
    "A" :rock
    "B" :paper
    "C" :scissors
    "X" :loss
    "Y" :draw 
    "Z" :win))

(defn ^:private calculate-points-part-2
  [acc match]
  (let [converted-match (map convert-part-2 match)
        [enemy-input expected-result] converted-match 
        round-points (get-in round-result-points [enemy-input expected-result])]
    (+ acc round-points)))

(defn rock-paper-scissors-part-2
  [input]
  (->> (str/split-lines input)
       (map #(str/split % #" "))
       (reduce calculate-points-part-2 0)))
