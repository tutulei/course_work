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
    list: []
  },

  onLoad: function () {
    var that = this
    that.getUserMsg()//读取信息
  },
  //获取文本框内容
  getUser_no(e) {
    this.setData({
      user_no: e.detail.value
    })
  },
  getUser_name(e) {
    this.setData({
      user_name: e.detail.value
    })
  },
  getUser_major(e) {
    this.setData({
      user_major: e.detail.value
    })
  },
  getUser_class(e) {
    this.setData({
      user_class: e.detail.value
    })
  },
  getUser_phone(e) {
    this.setData({
      user_phone: e.detail.value
    })
  },
  getUser_address(e) {
    this.setData({
      user_address: e.detail.value
    })
  },
  //获取信息
  getUserMsg() {
    var that = this
    const db = wx.cloud.database()
    db.collection(user).get({
      success: function (res) {
        console.log(res)
        that.setData({
          list: res.data
        })
      }
    })
  },
  //添加信息
  setUserMsg() {
    var that = this
    const db = wx.cloud.database()
    db.collection(user).add({
        data: {
          no: that.data.user_no,
          name: that.data.user_name,
          major: that.data.user_no,
          clas: that.data.user_class,
          phone: that.data.user_phone,
          address: that.data.user_address,
        },
        success: function (res) {
          console.log(res)
          that.getUserMsg()
        }
      })
  },
  //修改回显
  changeUserMsg(e) {
    var that = this
    var id = e.currentTarget.dataset.id
    const db = wx.cloud.database()

    db.collection(user).doc(id).get({
      success: function (res) {
        that.setData({
          no: that.data.user_no,
          name: that.data.user_name,
          major: that.data.user_no,
          clas: that.data.user_class,
          phone: that.data.user_phone,
          address: that.data.user_address,
          id: res.data.id
        })
      }
    })

  },
  //更新提交
  updateUserMsg(e) {
    var that = this
    var id = e.currentTarget.dataset.id
    const db = wx.cloud.database()
    db.collection(user).doc(id).update({
      data: {
        no: that.data.user_no,
        name: that.data.user_name,
        major: that.data.user_no,
        clas: that.data.user_class,
        phone: that.data.user_phone,
        address: that.data.user_address,
        id: res.data.id
      },
      success: function (res) {
        that.getUserMsg()
      }
    })
  },
})
