(defproject dual-oauth-test "0.1.0-SNAPSHOT"
  :description "OAuth Test using fb's response code with multiple apps"
  :main dual-oauth-test.core
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [environ "0.5.0"]
                 [compojure "1.5.1"]
                 [sudharsh/clj-oauth2 "0.5.3"]
                 [ring/ring-core "1.3.2"]
                 [ring/ring-json "0.3.1"]
                 [ring/ring-defaults "0.2.1"]
                 [jumblerg/ring.middleware.cors "1.0.1"]
                 [clj-http "2.2.0"]
                 [http-kit "2.1.18"]])
