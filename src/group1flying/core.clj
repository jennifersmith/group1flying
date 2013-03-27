(ns group1flying.core
  (:use flightgear.api))
(defn start-plane! []
  (if (engine-running?)
    (starter! false)
    (do (starter! true)
        (Thread/sleep 100)
        (start-plane!))))


(defn keep-heading []
  (let [heading (indicated-heading-deg)]
    (do
      (println "HEADING: " heading)
      (if (< heading 280) (rudder! 0.2) (rudder! -0.2))
      (Thread/sleep 100)
      keep-heading)
    )
)

(defn start-keep-heading []
  (future (trampoline keep-heading)))

(defn take-off
  []
  (do
    (start-plane!)
    (flaps! 0.5)
    (throttle! 1.5)
    (Thread/sleep 5000)
    (rudder! 0.1)))

(defn down-we-go []
  (rudder! -1.0))

()
(defn loop-the-loop
  []                                     ;(do )
  )

(defn -main
  "I don't do a whole lot."
  [& args]
  (println "Hello, World!"))
