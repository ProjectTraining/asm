@title 项目说明
@

1.包名的说明：
	......
	domain包：存放持久化对象model文件，相当于老师上课讲的model层
	vo：值对象用于保存不要和数据库做持久化的对象，如前台传过来的值，可以不用vo；

2.beans.xml说明
	beans.xml可以达到一个项目不用修改，使用注解的方式简单，灵活！
	（1）使用注解的方式做依赖注入
	<property name="packagesToScan">
			<list>
				<value>com.asm.domain</value>
			</list>
 	</property>
 	使得domain包下的所有类能够自动被扫描成为model,免去配置*.hbm,但是要进行如下配置
 	@Entity
	@Table(name="t_employee")
	
	@Id
	@GeneratedValue(generator="employeeUUID")
	@GenericGenerator(name="employeeUUID", strategy="uuid")
	
	（2）action中进行注解方式的配置
	
	@SuppressWarnings("serial")
	@Controller("manageAction")
	@Scope("prototype")
	
	@Autowired
	
	（3）service 中进行注解方式的配置
	配置service事务
	@Transactional(readOnly=true)
	@Service("employeeService")
	
	（4）dao中进行注解配置
	@Repository("employeeDao")

3.jdbc.properties进行数据库连接的配置
4.log4j.properties进行日志的配置
5.struts.xml
 	每个人自己建立自己的package，到时候自己配置，统一集成，自己使用自己习惯的配置方式
6.webroot下只有一个login.jsp文件，用于做跳转，所有页面放置在WEB-INF目录下，一个模块一个文件夹，用于存放该模块页面，防止非法链接

	
 	
 	
