(ns adventure-of-code-2022.day-1
  (:require [clojure.string :as str]))

(defn ^:private calories-by-elf
  [lines]
  (loop [line (first lines)
         remaining-lines (rest lines)
         acc-cal 0
         counting []] 
    (cond
      (nil? line) (if (zero? acc-cal) 
                    counting
                    (conj counting acc-cal))
      (= line "") (recur (first remaining-lines) (rest remaining-lines) 0 (conj counting acc-cal))
      :else (recur (first remaining-lines) (rest remaining-lines) (+ acc-cal (Integer/parseInt line)) counting))))

(defn calories-counting-part-1
  [input] 
  (->> input
       (str/split-lines)
       (calories-by-elf)
       (reduce max)))

(defn calories-counting-part-2
  [input] 
  (->> input
       (str/split-lines)
       (calories-by-elf)
       (sort)
       (reverse)
       (take 3)
       (reduce +)))
