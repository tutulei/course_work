Page({
  data: {
    id: '',//修改用来保存_id
    status_num: '1',
    user_no: '',
    venue_id: '',
    //reservation_date: '',
    reservation_usertools: false,
    reservation_menbercount: 0,
    reservation_menber: '',
    list:[]
  },

  onLoad: function () {
    var that = this
    that.getUserMsg()//读取信息
  },
  //获取文本框内容
  getReservation_usertoolsT(e) {
    this.setData({
      reservation_usertools: true
    })
  },
  getReservation_usertoolsF(e) {
    this.setData({
      reservation_usertools: false
    })
  },

  //获取信息
  getReservation() {
    var that = this
    const db = wx.cloud.database()
    db.collection(reservation).get({
      success: function (res) {
        console.log(res)
        that.setData({
          list: res.data
        })
      }
    })
  },
  //添加信息
  setReservationr() {
    var that = this
    const db = wx.cloud.database()
    db.collection(reservation).add({
      data: {
        tools: that.data.reservation_usertools
      },
      success: function (res) {
        console.log(res)
        that.setData({
          reservation_usertools: false
        })
        console.log(res)
        that.getReservation()
      }
    })
  },
  //删除信息
  delReservation(e) {
    var that = this
    const db = wx.cloud.database()
    var id = e.currentTarget.dataset.id
    db.collection(reservation).doc(id).remove({
      success: function (res) {
        console.log(res)
        that.getReservation()
      }
    })
  },
  //更新提交
  updateReservation(e) {
    var that = this
    var id = e.currentTarget.dataset.id
    const db = wx.cloud.database()
    db.collection(reservation).doc(id).update({
      data: {
        tools: that.data.reservation_usertools
      },
      success: function (res) {
        that.getReservation()
        that.setData({
          reservation_usertools: false
        })
      }
    })
  },
})
