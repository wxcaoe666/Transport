package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.HeadPortraits;
import com.model.User;
import com.model.Userselect;
import com.service.IUserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.rmi.server.UID;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

//@CrossOrigin(value = "http://localhost:9528", maxAge = 1800,allowedHeaders = "*",origins = "*")//跨域支持
@RestController
@CrossOrigin(maxAge = 1800,allowedHeaders = "*",origins = "*")//跨域支持
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/selectuserbyID", method = RequestMethod.GET)
    @ResponseBody
    public User selectuserbyID(int ID) {
        return userService.selectuserbyID(ID);
    }


    /**
     *修改用户信息
    */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    /**
     *修改用户权限
     */
    @RequestMapping(value = "/updateRole", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int updateRole(@RequestBody User user){
        User user1 = selectuserbyID(user.getID());
        String role = user1.getRole();
        if (Objects.equals(user.getRole(), "superadmin")){
            return 4;//superadmin权限无法赋予修改
        }

        if (Objects.equals(role, "superadmin")){
            return 3;//superadmin权限无法修改
        }else{
            return userService.updateRole(user);
        }
    }

    /**
     * 头像上传
     * @param file
     * @return
     * @throws IOException
     */
//    @RequestMapping(value = "/headportrait", method = RequestMethod.GET)
    @RequestMapping(value = "/headportrait/{UserID}",method = RequestMethod.POST)
    @ResponseBody
    public HeadPortraits headportrait(@RequestParam("file") MultipartFile file,@PathVariable("UserID") int UserID) throws IOException {
        byte[] bytes = file.getBytes();
        HeadPortraits headPortraits = userService.selectheadportraitsbyUserID(UserID);
        if (headPortraits == null) {
            HeadPortraits headPortraits1 = new HeadPortraits();
            headPortraits1.setUserID(UserID);
            headPortraits1.setPicture(bytes);
            int addheadportraits = userService.addheadportraits(headPortraits1);
            if (addheadportraits == 1) {
                return userService.selectheadportraitsbyUserID(UserID);
            } else {
                return null;
            }
        } else {
            headPortraits.setPicture(bytes);
            int updateheadportraits = userService.updateheadportraits(headPortraits);
            if (updateheadportraits == 1) {
                return userService.selectheadportraitsbyUserID(UserID);
            } else {
                return null;
            }
        }
//        //输出图片
//        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
//        BufferedImage bi1 = ImageIO.read(bais);
//        try {
//            File w2 = new File("D:\\tupian\\1.jpg");//可以是jpg,png,gif格式
//            ImageIO.write(bi1, "jpg", w2);//不管输出什么格式图片，此处不需改动
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally{
//            bais.close();
//        }
    }

    /**
     * 获取头像
     * @param UserID
     * @return
     */
    @RequestMapping(value = "/selectheadportraitsbyUserID", method = RequestMethod.GET)
    @ResponseBody
    public HeadPortraits selectheadportraitsbyUserID(int UserID){
        return userService.selectheadportraitsbyUserID(UserID);
    }

    //@RequestMapping(value = "/login", method = RequestMethod.POST)
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public User login(@RequestBody User user) {
        String userName = user.getUserName();
        String Password = user.getPassword();
        //User user1 = userService.login(userName, Password);
        return userService.login(userName, Password);
    }

    @RequestMapping("/selectUser")
    @ResponseBody
    public User selectUser(String userName) {
        return userService.selectUser(userName);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int register(@RequestBody User user) {
        String userName = user.getUserName();
        User user1 = userService.selectUser(userName);
        if (user1 == null) {
            UID uid = new UID();
            String guid = uid.toString();
            Timestamp d = new Timestamp(System.currentTimeMillis());
            user.setGuid(guid);
            user.setCreateTime(d);
            user.setDeleteFlag(0);
            user.setRole("common");
            return userService.register(user);
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "/getlist", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getlist(Userselect userselect) {
        return userService.getlist(userselect);
    }

    //条件查询分页
    @RequestMapping(value = "/getuserpage", method = RequestMethod.POST)
    @ResponseBody
    public PageInfo<User> getuserpage(@RequestBody Userselect userselect) {
        int pageNum = userselect.getPageNum();
        int pageSize = userselect.getPageSize();
        String selectname = userselect.getSelectname();
        if (selectname!=null&&selectname!=""){
            String str="%"+selectname+"%";
            userselect.setSelectname(str);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.getlist(userselect);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

}
