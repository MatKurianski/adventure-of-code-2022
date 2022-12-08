(ns adventure-of-code-2022.day-6)

(defn tuning-trouble-part-1
  [input]
  (loop [start 0
         end 4]
    (if
      (> end (count input)) -1
      (let [substring (subs input start end)]
        (if (= (count (set substring))
               (count substring))
          end
          (recur (inc start) (inc end)))))))

(defn tuning-trouble-part-2
  [input]
  (loop [start 0
         end 14]
    (if
     (> end (count input)) -1
     (let [substring (subs input start end)]
       (if (= (count (set substring))
              (count substring))
         end
         (recur (inc start) (inc end)))))))
