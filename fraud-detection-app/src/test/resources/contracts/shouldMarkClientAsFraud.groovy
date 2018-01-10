import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'PUT'
        url '/fraudcheck'
        body(
                clientId: $(anyNumber()),
                loanAmount: $(consumer(regex('^([5-9]\\d{4}|\\d{6,})$')), producer(50000))
        )
        headers {
            header('Content-Type', applicationJsonUtf8())
        }
    }
    response {
        status 200
        body("""
  {
    "fraudCheckStatus": "FRAUD",
    "rejectionReason": "Amount too high"
  }
  """)
        headers {
            header('Content-Type': applicationJsonUtf8())
        }
    }
}