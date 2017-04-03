## 项目

### 申请项目
#### URL:/api/project/apply
#### 请求方式：GET
#### 参数列表：
参数名|类型|必选|说明
-----|---|----|---|
userId|String|√|申请人的userId
title|String|√|项目名称
description|String|√|描述
applyAmount|Integer|√|申请金额
tags|String|√|标签
interest|double|√|利息
minBought|Integer|√|最低买入金额
biginDate|String|√|众筹开始时间
endDate|String|√|众筹结束时间

#### 返回示例：
```
{
  "status": 0,
  "msg": "申请成功"
}
```

### 获取所有的项目标签
#### URL:/api/project/tags
#### 请求方式：GET
#### 参数列表：无
#### 返回示例：
```
{
  "status": 0,
  "data": {
    "tags": [
      "房屋抵押",
      "可转让"
    ]
  }
}
```

### 查看我的所有申请项目
#### URL:/api/project/list/{userId}
#### 请求方式：GET
#### 参数列表：
参数名|类型|必选|说明
-----|---|----|---|
userId|String|√|userId
#### 返回示例：
```
{
  "status": 0,
  "data": [
    {
      "projectId": "2324ksd",
      "title": "测试项目2",
      "description": "test",
      "applyAmount": 2222,
      "bought": 0,
      "tags": [
        "可转让"
      ],
      "beginDate": "2017-04-25 17:52:41",
      "endDate": "2017-07-28 17:52:31",
      "interest": 10.0,
      "minBought": 500,
      "userId": "fd7917c5312a4e818e3ae58bb997e9e4",
      "days": -5
    },
    {
      "projectId": "asdfasfd",
      "title": "测试项目1",
      "description": "甩卖甩卖",
      "applyAmount": 1111,
      "bought": 100,
      "tags": [
        "房屋抵押",
        "可转让"
      ],
      "beginDate": "2017-04-01 17:51:50",
      "endDate": "2017-04-30 17:51:40",
      "interest": 8.0,
      "minBought": 100,
      "userId": "fd7917c5312a4e818e3ae58bb997e9e4",
      "days": -20
    }
  ]
}
```