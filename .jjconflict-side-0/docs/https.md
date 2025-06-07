# HTTPS / TLS

You probably want your server to use HTTPS, so not everyone on the same network
can read the sensitive information passed to the proxy server in plaintext.

For a simple explainer, see [Julia Evan's Twitter comic about it](https://twitter.com/b0rk/status/809594614147645440/photo/1).

We previously had [custom code to retrieve certs](https://github.com/SuffolkLITLab/EfileProxyServer/blob/b287ed3fe42e71458b8a594d0287d542b6f6035e/docs/https.md#getting-a-certificate), but now use our hosting provider, fly, to [generate certs for us](https://fly.io/docs/flyctl/certs/). We recommend something similar for folks looking to run
their own version of this server. If your hosting provider doesn't provide certs, you can
look into using [nginx and letsencrypt together](esc.sh/blog/lets-encrypt-and-nginx-definitive-guide/) as a reverse proxy for this server.
