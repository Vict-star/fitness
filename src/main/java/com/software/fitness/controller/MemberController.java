package com.software.fitness.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    public static final String LOGIN_MEMBER = "fitness.loginMember";
/**
 @Autowired MemberService memberService;

 public String memberManagePage(HttpServletRequest request) {
 Member member = (Member) request.getSession().getAttribute(LOGIN_MEMBER);
 if(member == null){
 return "Login";
 }
 else {
 return "member/index";
 }
 }

 @PostMapping("/Login") public String memberlogin(@RequestParam String userId, @RequestParam String password,
 RedirectAttributes attributes, HttpServletRequest request) {
 User user = userService.getUserById(userId);
 System.out.print(user);
 if (user != null && user.getPassword().equals(password)) {
 user.setPassword("");
 request.getSession().setAttribute("loginUser", user);
 return "/admin/index";
 } else {
 attributes.addFlashAttribute("message", "用户名或密码错误");
 return "redirect:/index";
 }
 }

 @GetMapping("/Logout") public String userloginOut(HttpServletRequest request) {
 request.getSession().removeAttribute("loginUser");
 return "redirect:/index";
 }
 */
}
