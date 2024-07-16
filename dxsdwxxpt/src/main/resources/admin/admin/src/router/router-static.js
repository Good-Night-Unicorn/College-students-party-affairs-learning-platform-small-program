import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import dangan from '@/views/modules/dangan/list'
    import dangke from '@/views/modules/dangke/list'
    import dangkeCollection from '@/views/modules/dangkeCollection/list'
    import dangkeCommentback from '@/views/modules/dangkeCommentback/list'
    import dangkeOrder from '@/views/modules/dangkeOrder/list'
    import dictionary from '@/views/modules/dictionary/list'
    import exampaper from '@/views/modules/exampaper/list'
    import exampapertopic from '@/views/modules/exampapertopic/list'
    import examquestion from '@/views/modules/examquestion/list'
    import examrecord from '@/views/modules/examrecord/list'
    import examredetails from '@/views/modules/examredetails/list'
    import examrewrongquestion from '@/views/modules/examrewrongquestion/list'
    import gonggao from '@/views/modules/gonggao/list'
    import gongzuo from '@/views/modules/gongzuo/list'
    import kaoqin from '@/views/modules/kaoqin/list'
    import liuyan from '@/views/modules/liuyan/list'
    import shenqingYuyue from '@/views/modules/shenqingYuyue/list'
    import tixing from '@/views/modules/tixing/list'
    import xuexi from '@/views/modules/xuexi/list'
    import xuexiCollection from '@/views/modules/xuexiCollection/list'
    import xuexiLiuyan from '@/views/modules/xuexiLiuyan/list'
    import yonghu from '@/views/modules/yonghu/list'
    import zuoye from '@/views/modules/zuoye/list'
    import zuoyeTijiao from '@/views/modules/zuoyeTijiao/list'
    import config from '@/views/modules/config/list'
    import dictionaryDangan from '@/views/modules/dictionaryDangan/list'
    import dictionaryDangke from '@/views/modules/dictionaryDangke/list'
    import dictionaryDangkeCollection from '@/views/modules/dictionaryDangkeCollection/list'
    import dictionaryDangkeOrder from '@/views/modules/dictionaryDangkeOrder/list'
    import dictionaryExampaper from '@/views/modules/dictionaryExampaper/list'
    import dictionaryExamquestion from '@/views/modules/dictionaryExamquestion/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryKaoqin from '@/views/modules/dictionaryKaoqin/list'
    import dictionaryKemu from '@/views/modules/dictionaryKemu/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShenqingYuyue from '@/views/modules/dictionaryShenqingYuyue/list'
    import dictionaryShenqingYuyueYesno from '@/views/modules/dictionaryShenqingYuyueYesno/list'
    import dictionaryXuexi from '@/views/modules/dictionaryXuexi/list'
    import dictionaryXuexiCollection from '@/views/modules/dictionaryXuexiCollection/list'
    import dictionaryZujuan from '@/views/modules/dictionaryZujuan/list'
    import dictionaryZuoye from '@/views/modules/dictionaryZuoye/list'
    import dictionaryZuoyeTijiaoYesno from '@/views/modules/dictionaryZuoyeTijiaoYesno/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryDangan',
        name: '档案类型',
        component: dictionaryDangan
    }
    ,{
        path: '/dictionaryDangke',
        name: '党课类型',
        component: dictionaryDangke
    }
    ,{
        path: '/dictionaryDangkeCollection',
        name: '收藏表类型',
        component: dictionaryDangkeCollection
    }
    ,{
        path: '/dictionaryDangkeOrder',
        name: '订单类型',
        component: dictionaryDangkeOrder
    }
    ,{
        path: '/dictionaryExampaper',
        name: '试卷状态',
        component: dictionaryExampaper
    }
    ,{
        path: '/dictionaryExamquestion',
        name: '试题类型',
        component: dictionaryExamquestion
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryKaoqin',
        name: '考勤结果',
        component: dictionaryKaoqin
    }
    ,{
        path: '/dictionaryKemu',
        name: '科目',
        component: dictionaryKemu
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShenqingYuyue',
        name: '申请进度',
        component: dictionaryShenqingYuyue
    }
    ,{
        path: '/dictionaryShenqingYuyueYesno',
        name: '报名状态',
        component: dictionaryShenqingYuyueYesno
    }
    ,{
        path: '/dictionaryXuexi',
        name: '在线学习类型',
        component: dictionaryXuexi
    }
    ,{
        path: '/dictionaryXuexiCollection',
        name: '收藏表类型',
        component: dictionaryXuexiCollection
    }
    ,{
        path: '/dictionaryZujuan',
        name: '组卷方式',
        component: dictionaryZujuan
    }
    ,{
        path: '/dictionaryZuoye',
        name: '作业类型',
        component: dictionaryZuoye
    }
    ,{
        path: '/dictionaryZuoyeTijiaoYesno',
        name: '提交状态',
        component: dictionaryZuoyeTijiaoYesno
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dangan',
        name: '档案',
        component: dangan
      }
    ,{
        path: '/dangke',
        name: '党课',
        component: dangke
      }
    ,{
        path: '/dangkeCollection',
        name: '党课收藏',
        component: dangkeCollection
      }
    ,{
        path: '/dangkeCommentback',
        name: '党课评价',
        component: dangkeCommentback
      }
    ,{
        path: '/dangkeOrder',
        name: '党课报名',
        component: dangkeOrder
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/exampaper',
        name: '试卷',
        component: exampaper
      }
    ,{
        path: '/exampapertopic',
        name: '试卷选题',
        component: exampapertopic
      }
    ,{
        path: '/examquestion',
        name: '试题表',
        component: examquestion
      }
    ,{
        path: '/examrecord',
        name: '考试记录表',
        component: examrecord
      }
    ,{
        path: '/examredetails',
        name: '答题详情表',
        component: examredetails
      }
    ,{
        path: '/examrewrongquestion',
        name: '错题表',
        component: examrewrongquestion
      }
    ,{
        path: '/gonggao',
        name: '公告信息',
        component: gonggao
      }
    ,{
        path: '/gongzuo',
        name: '党务工作者',
        component: gongzuo
      }
    ,{
        path: '/kaoqin',
        name: '签到信息',
        component: kaoqin
      }
    ,{
        path: '/liuyan',
        name: '谈心谈话',
        component: liuyan
      }
    ,{
        path: '/shenqingYuyue',
        name: '入党申请',
        component: shenqingYuyue
      }
    ,{
        path: '/tixing',
        name: '提醒',
        component: tixing
      }
    ,{
        path: '/xuexi',
        name: '在线学习',
        component: xuexi
      }
    ,{
        path: '/xuexiCollection',
        name: '在线学习收藏',
        component: xuexiCollection
      }
    ,{
        path: '/xuexiLiuyan',
        name: '在线学习留言',
        component: xuexiLiuyan
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/zuoye',
        name: '作业',
        component: zuoye
      }
    ,{
        path: '/zuoyeTijiao',
        name: '作业提交',
        component: zuoyeTijiao
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
