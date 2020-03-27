Page({
  data: {
    id:  '',
    status_num: '',
    open_id: '',
    //open_data: '',
    list: []
  },

  onLoad: function () {
    that.getUserMsg()//读取信息
  },

  //获取信息
  getOpenVenue() {
    const db = wx.cloud.database()
    db.collection(openvenue).get({
      success: function (res) {
        console.log(res)
        this.setData({
          list: res.data
        })
      }
    })
  },
  //更新提交
  updateOpenVenue(e) {
    var id = e.currentTarget.dataset.id
    const db = wx.cloud.database()
    db.collection(openvenue).doc(id).update({
      data: {
        venue_id: '',
        status_num: '',
        open_id: '',
        open_data: '',
      },
      success: function (res) {
        this.getOpenVenueMsg()
        this.setData({
          venue_id: '',
          status_num: '',
          open_id: '',
          open_data: '',
        })
      }
    })
  },
})
