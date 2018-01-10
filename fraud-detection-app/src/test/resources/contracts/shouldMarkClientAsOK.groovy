import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'PUT'
        url '/fraudcheck'
        body(
                clientId: $(anyNumber()),
                loanAmount: $(consumer(regex('^([1-4]\\d{4}|\\d{1,4})$')), producer(9500))
        )
        headers {
            header('Content-Type', applicationJsonUtf8())
        }
    }
    response {
        status 200
        body("""
  {
    "fraudCheckStatus": "OK",
    "rejectionReason": ""
  }
  """)
        headers {
            header('Content-Type': applicationJsonUtf8())
        }
    }
}