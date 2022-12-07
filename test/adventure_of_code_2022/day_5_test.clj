(ns adventure-of-code-2022.day-5-test
  (:require [clojure.test :refer :all]
            [adventure-of-code-2022.day-5 :as day-5]))

(deftest camp-cleanup-part-1-test
  (testing "Testing camp-cleanup-part-1"
    (let [input-1 (slurp "./resources/test/day_5/input1.txt")
          input-2 (slurp "./resources/test/day_5/input2.txt")]
      (is (= "CMZ" (day-5/supply-stacks-part-1 input-1)))
      (is (= "SHQWSRBDL" (day-5/supply-stacks-part-1 input-2))))))

(deftest camp-cleanup-part-2-test
  (testing "Testing camp-cleanup-part-2"
    (let [input-1 (slurp "./resources/test/day_5/input1.txt")
          input-2 (slurp "./resources/test/day_5/input2.txt")]
      (is (= "MCD" (day-5/supply-stacks-part-2 input-1)))
      (is (= "CDTQZHBRS" (day-5/supply-stacks-part-2 input-2))))))
