
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 错题表
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/examrewrongquestion")
public class ExamrewrongquestionController {
    private static final Logger logger = LoggerFactory.getLogger(ExamrewrongquestionController.class);

    private static final String TABLE_NAME = "examrewrongquestion";

    @Autowired
    private ExamrewrongquestionService examrewrongquestionService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DanganService danganService;//档案
    @Autowired
    private DangkeService dangkeService;//党课
    @Autowired
    private DangkeCollectionService dangkeCollectionService;//党课收藏
    @Autowired
    private DangkeCommentbackService dangkeCommentbackService;//党课评价
    @Autowired
    private DangkeOrderService dangkeOrderService;//党课报名
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ExampaperService exampaperService;//试卷
    @Autowired
    private ExampapertopicService exampapertopicService;//试卷选题
    @Autowired
    private ExamquestionService examquestionService;//试题表
    @Autowired
    private ExamrecordService examrecordService;//考试记录表
    @Autowired
    private ExamredetailsService examredetailsService;//答题详情表
    @Autowired
    private GonggaoService gonggaoService;//公告信息
    @Autowired
    private GongzuoService gongzuoService;//党务工作者
    @Autowired
    private KaoqinService kaoqinService;//签到信息
    @Autowired
    private LiuyanService liuyanService;//谈心谈话
    @Autowired
    private ShenqingYuyueService shenqingYuyueService;//入党申请
    @Autowired
    private TixingService tixingService;//提醒
    @Autowired
    private XuexiService xuexiService;//在线学习
    @Autowired
    private XuexiCollectionService xuexiCollectionService;//在线学习收藏
    @Autowired
    private XuexiLiuyanService xuexiLiuyanService;//在线学习留言
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private ZuoyeService zuoyeService;//作业
    @Autowired
    private ZuoyeTijiaoService zuoyeTijiaoService;//作业提交
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("党务工作者".equals(role))
            params.put("gongzuoId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = examrewrongquestionService.queryPage(params);

        //字典表数据转换
        List<ExamrewrongquestionView> list =(List<ExamrewrongquestionView>)page.getList();
        for(ExamrewrongquestionView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ExamrewrongquestionEntity examrewrongquestion = examrewrongquestionService.selectById(id);
        if(examrewrongquestion !=null){
            //entity转view
            ExamrewrongquestionView view = new ExamrewrongquestionView();
            BeanUtils.copyProperties( examrewrongquestion , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(examrewrongquestion.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 试卷
            //级联表
            ExampaperEntity exampaper = exampaperService.selectById(examrewrongquestion.getExampaperId());
            if(exampaper != null){
            BeanUtils.copyProperties( exampaper , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setExampaperId(exampaper.getId());
            }
            //级联表 试题表
            //级联表
            ExamquestionEntity examquestion = examquestionService.selectById(examrewrongquestion.getExamquestionId());
            if(examquestion != null){
            BeanUtils.copyProperties( examquestion , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setExamquestionId(examquestion.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ExamrewrongquestionEntity examrewrongquestion, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,examrewrongquestion:{}",this.getClass().getName(),examrewrongquestion.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            examrewrongquestion.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ExamrewrongquestionEntity> queryWrapper = new EntityWrapper<ExamrewrongquestionEntity>()
            .eq("yonghu_id", examrewrongquestion.getYonghuId())
            .eq("exampaper_id", examrewrongquestion.getExampaperId())
            .eq("examquestion_id", examrewrongquestion.getExamquestionId())
            .eq("examredetails_myanswer", examrewrongquestion.getExamredetailsMyanswer())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ExamrewrongquestionEntity examrewrongquestionEntity = examrewrongquestionService.selectOne(queryWrapper);
        if(examrewrongquestionEntity==null){
            examrewrongquestion.setInsertTime(new Date());
            examrewrongquestion.setCreateTime(new Date());
            examrewrongquestionService.insert(examrewrongquestion);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ExamrewrongquestionEntity examrewrongquestion, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,examrewrongquestion:{}",this.getClass().getName(),examrewrongquestion.toString());
        ExamrewrongquestionEntity oldExamrewrongquestionEntity = examrewrongquestionService.selectById(examrewrongquestion.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            examrewrongquestion.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            examrewrongquestionService.updateById(examrewrongquestion);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ExamrewrongquestionEntity> oldExamrewrongquestionList =examrewrongquestionService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        examrewrongquestionService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<ExamrewrongquestionEntity> examrewrongquestionList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ExamrewrongquestionEntity examrewrongquestionEntity = new ExamrewrongquestionEntity();
//                            examrewrongquestionEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户id 要改的
//                            examrewrongquestionEntity.setExampaperId(Integer.valueOf(data.get(0)));   //试卷（外键） 要改的
//                            examrewrongquestionEntity.setExamquestionId(Integer.valueOf(data.get(0)));   //试题id（外键） 要改的
//                            examrewrongquestionEntity.setExamredetailsMyanswer(data.get(0));                    //考生作答 要改的
//                            examrewrongquestionEntity.setInsertTime(date);//时间
//                            examrewrongquestionEntity.setCreateTime(date);//时间
                            examrewrongquestionList.add(examrewrongquestionEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        examrewrongquestionService.insertBatch(examrewrongquestionList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = examrewrongquestionService.queryPage(params);

        //字典表数据转换
        List<ExamrewrongquestionView> list =(List<ExamrewrongquestionView>)page.getList();
        for(ExamrewrongquestionView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ExamrewrongquestionEntity examrewrongquestion = examrewrongquestionService.selectById(id);
            if(examrewrongquestion !=null){


                //entity转view
                ExamrewrongquestionView view = new ExamrewrongquestionView();
                BeanUtils.copyProperties( examrewrongquestion , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(examrewrongquestion.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    ExampaperEntity exampaper = exampaperService.selectById(examrewrongquestion.getExampaperId());
                if(exampaper != null){
                    BeanUtils.copyProperties( exampaper , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setExampaperId(exampaper.getId());
                }
                //级联表
                    ExamquestionEntity examquestion = examquestionService.selectById(examrewrongquestion.getExamquestionId());
                if(examquestion != null){
                    BeanUtils.copyProperties( examquestion , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setExamquestionId(examquestion.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ExamrewrongquestionEntity examrewrongquestion, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,examrewrongquestion:{}",this.getClass().getName(),examrewrongquestion.toString());
        Wrapper<ExamrewrongquestionEntity> queryWrapper = new EntityWrapper<ExamrewrongquestionEntity>()
            .eq("yonghu_id", examrewrongquestion.getYonghuId())
            .eq("exampaper_id", examrewrongquestion.getExampaperId())
            .eq("examquestion_id", examrewrongquestion.getExamquestionId())
            .eq("examredetails_myanswer", examrewrongquestion.getExamredetailsMyanswer())
//            .notIn("examrewrongquestion_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ExamrewrongquestionEntity examrewrongquestionEntity = examrewrongquestionService.selectOne(queryWrapper);
        if(examrewrongquestionEntity==null){
            examrewrongquestion.setInsertTime(new Date());
            examrewrongquestion.setCreateTime(new Date());
        examrewrongquestionService.insert(examrewrongquestion);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

