## Dual OAuth Test

This is a simple project I threw together to test whether the code that facebook sends back in its initial OAuth redirect can be used by another server to get the access token and do subsequent interactions like get profile information.

In my test, app 1 does the initial OAuth redirect and gets the code. It sends a request to app2 with the code, and app2 uses the code to get the token and uses the token to get profile information. App2 then sends the profile information back to app1.

This approach works. However, it's important to note that the redirect_url sent when getting the initial code must match the redirect_url sent when getting the access token.
