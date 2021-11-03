## 1 实体类的设计
实体类
- 博客类 Blog
  - 标题 内容 标记 浏览次数
  - 评论开启 关注开启 版权开启
  - 发布 创建时间 更新时间
  - 分类 标签 评论 用户
  - 只能在发布界面更新其标签和分类，后面不支持更新操作
- 博客分类 Type
  - Type 分类
- 博客标签 Tag
  - Tag 名称
- 博客评论 Comment
  - 评论之间具有父子关系，博客评论之间的关系包含在Class里面
  - 昵称 邮箱 头像 评论内容 创建时间
- 用户 User
  - 昵称 用户名 密码
  - 邮箱 类型 头像
  - 创建时间 博客更新时间

实体类之间的关系

![img.png](readmeResource/img/img.png)

### 1.2 应用分层

![img_1.png](readmeResource/img/img_1.png)

### 1.3 命名方式
Service / Dao 层命名方式
- 获取单个对象  利用get做前缀
- 获取多个对象  用list做前缀
- 获取统计值阿  用count做前缀
- 插入方法     利用insert做前缀
- 删除方法     利用delete做前缀
- 修改方法     利用update做前缀

## 2 后台管理

### 2.1登录管理方式

#### 简单的管理登录方式

利用登录拦截器去实现用户的登录
当用户进入进入登录页面时候
- 输入正确用户名和密码，跳转到后台管理界面，并且加入用户的相关信息到cookies中
- 输入错误，重定向到登录界面(利用
  ```java
    redirectAttributes.addFlashAttribute("message", "用户名和密码错误");
    return "redirect:/admin";
  ```
  这种方式实现重定向并且返回错误信息.
  如果利用model的方式放回错误信息的话，重定向会导致携带的信息丢失。)
  
- 用户尝试未登录直接进入/admin下面的子页面，利用拦截器直接重定向到登录界面

#### 利用Apache Shiro来完成身份验证和授权 有待完成

#### 利用Spring Security来完成身份验证和授权 有待完成
