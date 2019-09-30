package controller;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.Controller;

/**
 * @Description
 * @Author Heling
 * @Date 2019/9/30 11:25
 **/
public class LoginController implements Controller {

    public void handleActionRequest(javax.portlet.ActionRequest actionRequest, javax.portlet.ActionResponse actionResponse) throws Exception {

    }

    public ModelAndView handleRenderRequest(javax.portlet.RenderRequest renderRequest, javax.portlet.RenderResponse renderResponse) throws Exception {
        return new ModelAndView("/WEB-INF/jsp/login.jsp");
    }
}