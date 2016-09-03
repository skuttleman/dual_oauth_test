(ns dual-oauth-test.services.fb
  (:require [environ.core :refer [env]]
            [clj-oauth2.client :as oauth2]))

(def oauth-config {:redirect-uri "http://localhost:3000/callback"
                   :client-id (env :fb-app-id)
                   :client-secret (env :fb-app-secret)
                   :scope ["email" "public_profile"]
                   :authorization-uri "https://graph.facebook.com/oauth/authorize"
                   :access-token-uri "https://graph.facebook.com/oauth/access_token"
                   :access-query-param :access_token
                   :grant-type "authorization_code"
                   :approval_prompt ""})

(defn make-logout-url [token]
  (->> oauth-config
    (:redirect-uri)
    (str "https://www.facebook.com/logout.php?access_token=" token "&next=")))

(def redirect-url (oauth2/make-auth-request oauth-config))
