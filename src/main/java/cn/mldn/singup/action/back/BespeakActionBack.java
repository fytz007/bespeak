package cn.mldn.singup.action.back;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.singup.service.back.IBespeakServiceBack;
import cn.mldn.util.action.AbstractAction;
import cn.mldn.util.split.SplitPageUtil;
@Controller
@RequestMapping("/admin/bespeak/*")
public class BespeakActionBack extends AbstractAction {
	@Resource
	private IBespeakServiceBack bespeakServiceBack ;
	
	@RequestMapping("list")
	@RequiresRoles("bespeak")
	@RequiresPermissions("bespeak:list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getValue("back.bespeak.list.page")) ;
		SplitPageUtil spu = new SplitPageUtil(request, "name"); // 可以接收到所有的分页数据
		Map<String, Object> result = this.bespeakServiceBack.listByStatus(spu.getColumn(), spu.getKeyWord(), spu.getCurrentPage(),
				spu.getLineSize(),null);
		super.handleSplit(mav, result.get("bespeakCount"), "真实姓名:name|联系电话:phone|学历:edu|毕业院校:school|报名类型:type|信息来源:src", "back.bespeak.list.action", spu);
		mav.addObject("allBespeaks", result.get("allBespeaks")); // 真正需要进行显示的数据的集合
		return mav ;
	}
	@RequestMapping("wait")
	@RequiresRoles("bespeak")
	@RequiresPermissions("bespeak:list")
	public ModelAndView wait(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getValue("back.bespeak.list.page")) ;
		SplitPageUtil spu = new SplitPageUtil(request, "name"); // 可以接收到所有的分页数据
		Map<String, Object> result = this.bespeakServiceBack.listByStatus(spu.getColumn(), spu.getKeyWord(), spu.getCurrentPage(),
				spu.getLineSize(),0); 
		super.handleSplit(mav, result.get("bespeakCount"), "真实姓名:name|联系电话:phone|学历:edu|毕业院校:school|报名类型:type|信息来源:src", "back.bespeak.list.wait.action", spu);
		mav.addObject("allBespeaks", result.get("allBespeaks")); // 真正需要进行显示的数据的集合
		return mav ;
	}
	@RequestMapping("finish")
	@RequiresRoles("bespeak")
	@RequiresPermissions("bespeak:list")
	public ModelAndView finish(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getValue("back.bespeak.list.page")) ;
		SplitPageUtil spu = new SplitPageUtil(request, "name"); // 可以接收到所有的分页数据
		Map<String, Object> result = this.bespeakServiceBack.listByStatus(spu.getColumn(), spu.getKeyWord(), spu.getCurrentPage(),
				spu.getLineSize(),1);  
		super.handleSplit(mav, result.get("bespeakCount"), "真实姓名:name|联系电话:phone|学历:edu|毕业院校:school|报名类型:type|信息来源:src", "back.bespeak.list.finish.action", spu);
		mav.addObject("allBespeaks", result.get("allBespeaks")); // 真正需要进行显示的数据的集合
		return mav ;
	}
	@RequestMapping("invalid")
	@RequiresRoles("bespeak")
	@RequiresPermissions("bespeak:list")
	public ModelAndView invalid(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getValue("back.bespeak.list.page")) ;
		SplitPageUtil spu = new SplitPageUtil(request, "name"); // 可以接收到所有的分页数据
		Map<String, Object> result = this.bespeakServiceBack.listByStatus(spu.getColumn(), spu.getKeyWord(), spu.getCurrentPage(),
				spu.getLineSize(),2);   
		super.handleSplit(mav, result.get("bespeakCount"), "真实姓名:name|联系电话:phone|学历:edu|毕业院校:school|报名类型:type|信息来源:src", "back.bespeak.list.invalid.action", spu);
		mav.addObject("allBespeaks", result.get("allBespeaks")); // 真正需要进行显示的数据的集合
		return mav ;
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFileUploadDir() {
		// TODO Auto-generated method stub
		return null;
	}

}