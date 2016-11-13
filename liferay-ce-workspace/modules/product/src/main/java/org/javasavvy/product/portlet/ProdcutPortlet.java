package org.javasavvy.product.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.javasavvy.product.model.Product;
import org.javasavvy.product.service.ProductLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=product Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class ProdcutPortlet extends MVCPortlet {
	
	
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		super.doView(renderRequest, renderResponse);
	}
	
	
	public void addProduct(ActionRequest actionRequest,ActionResponse response){
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		
		String name = ParamUtil.getString(actionRequest, "name");
		System.out.println("Product called"+name);
		
		Product pr  = ProductLocalServiceUtil.createProduct(CounterLocalServiceUtil.increment());
		pr.setName(name);
		pr.setCreateDate(new Date());
		pr.setCompanyId(themeDisplay.getCompanyId());
		
		pr = ProductLocalServiceUtil.addProduct(pr);
	
		
		
	}
}