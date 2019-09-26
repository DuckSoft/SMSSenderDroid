## 通信规约
> Version: 0.1
### 注册
手机先向服务器发送注册请求包（register）：
```json
{
  "type": "register",
  "data": {
    "peerId": "<some uuid>"
  }
}
```

服务器核收后，返回注册确认包（registerAck）。
若超时未收到包，则判定连接服务器失败/服务器宕机。
```json
{
  "type": "registerAck",
  "data": null
}
```

### 发送短信
服务器向客户端发送短信请求包（smsSend）：
```json
{
  "type": "smsSend",
  "data": {
    "phone": "+86 151-1416-9986",
    "content": "柚子社新作发布啦",
    "msgId": "<some uuid>"
  }
}
```

客户端收到短信请求包之后，立即回应短信请求核收包（smsSendAck）。
超时未发送核收包，服务器将稍后在其他客户端重试此短信请求。
```json
{
  "type": "smsSendAck",
  "data": null
}
```

客户端开始发送短信。短信发送操作完成后，将是否成功项填入短信请求结果包（smsSendResult）的结果（result）布尔值中，发送给服务器。
```json
{
  "type": "smsSendResult",
  "data": {
    "msgId": "<some uuid>",
    "result": true
  }
}
```

### 解除注册
客户端向服务器发送解除注册包（unregister）：
```json
{
  "type": "unregister",
  "data": {
    "peerId": "<some uuid>"
  }
}
```

服务器返回解除注册确认包，完成解除注册。
```json
{
  "type": "unregisterAck",
  "data": null
}
```
