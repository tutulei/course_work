Page({
  data: {
    id: '',//修改用来保存_id
    user_no: '',
    status_num: '1',
    user_name: '',
    user_major: '',
    user_class: '',
    user_phone: '',
    user_deftimes: '0',
    user_address: '',
    openid: '',
    //可以通过 getWXContext 方法获取的用户登录态 `openId` 和小程序 `appId` 信息
    //如 let { OPENID, APPID } = cloud.getWXContext()
    list: []
  },

//增
setUser(){
  const db = wx.cloud.database()
  db.collection(user).add({
   data: {
      id: '',
      user_no: '',
      status_num: '1',
      user_name: '',
      user_major: '',
      user_class: '',
      user_phone: '',
      user_deftimes: '0',
      user_address: '',
      openid: '',
   },
    success: function (res) {
      console.log(res)
    }
  })
},

//删
delUser(e) {
  const db = wx.cloud.database()
  var id = e.currentTarget.dataset.id
  db.collection(user).doc(openid).remove({
    success: function (res) {
      console.log(res)
      this.getUserMsg()
    }
  })
},

//改
updateUser(e) {
  var id = e.currentTarget.dataset.id
  const db = wx.cloud.database()
  db.collection(user).doc(id).update({
    data: {
      user_no: '',
      status_num: '1',
      user_name: '',
      user_major: '',
      user_class: '',
      user_phone: '',
      user_deftimes: '0',
      user_address: '',
    },
    success: function (res) {
      this.getUserMsg()
    }
  })
},

//查
getUser(){
  const db = wx.cloud.database()
  db.collection(user).doc(openid).get({
    success: function (res) {
      console.log(res.data)
    }
  })
}
})
