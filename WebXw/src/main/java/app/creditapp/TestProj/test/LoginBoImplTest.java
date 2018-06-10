package app.creditapp.TestProj.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.creditapp.sys.bo.SysUserBo;
import app.creditapp.sys.entity.SysUser;
/*
 * ���Լ̳�AbstractTransactionalSpringContextTests�����
 * �̳и��࣬���Բ��Խ���������ƣ�������ɺ��Զ��ع�
 * */
@RunWith(SpringJUnit4ClassRunner.class)
//locations:����ֵ�������ļ���ַ���ı�
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class LoginBoImplTest extends AbstractTransactionalJUnit4SpringContextTests{

	
	//ע��service����
    @Autowired
    private SysUserBo sysUserBo;
    @Test
    //�����Լ���@RollBackע�� @Transactionע�����Է�����������ע��
    public void testFindItemsList() throws Exception {
    	SysUser op = new SysUser();
    	op.setUser_no("su1573");
		op.setPass_word("000000");
    	
    	SysUser sysUser = sysUserBo.getById(op);
    	
        System.out.println(sysUser.getId_no());
    }   
}
