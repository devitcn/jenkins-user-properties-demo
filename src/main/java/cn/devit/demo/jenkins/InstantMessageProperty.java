/*
 *    Copyright 2018 lxbzmy@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.devit.demo.jenkins;

import javax.annotation.Nonnull;

import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.export.Exported;

import cn.devit.demo.jenkins.i18n.Messages;
import hudson.Extension;
import hudson.Util;
import hudson.model.User;
import hudson.model.UserProperty;
import hudson.model.UserPropertyDescriptor;
import hudson.model.Descriptor.FormException;
import net.sf.json.JSONObject;

/**
 * Per user property that is e-mail address.
 */
public class InstantMessageProperty extends hudson.model.UserProperty {
    /**
     * The user's qq address
     * Null to leave it to default.
     */
    private final String qq;

    private final String mobile;

    public InstantMessageProperty(String qq, String mobile) {
        this.qq = qq;
        this.mobile = mobile;
    }

    /**
     * qq号
     */
    @Exported
    public String getQq() {
        String trim = Util.fixEmptyAndTrim(qq);
        if (trim != null) {
            return trim;
        }
        //如果注册账号像是QQ号码，则借用过来
        if(user.getFullName().matches("^\\d{6,10}$")) {
            return user.getFullName();
        }
        return null;
    }

    /**
     * 手机号
     */
    @Exported
    public String getMobilePhone() {
        String trim = Util.fixEmptyAndTrim(mobile);
        if(trim !=null) {
            return trim;
        }
        //如果账号名字像是手机号码，则使用账号名字
        if(user.getFullName().matches("^\\d{11}$")) {
            return user.getFullName();
        }
        return null;
    }
    
    


    @Extension
    public static final class DescriptorImpl extends UserPropertyDescriptor {

        @Override
        public @Nonnull String getDisplayName() {
            return Messages.IM_DisplayName();
        }

        public UserProperty newInstance(User user) {
            //TODO you can guess default value from user.
            //eg. username 
            return new InstantMessageProperty(null, null);
        }

        @Override
        public UserProperty newInstance(StaplerRequest req, @Nonnull JSONObject formData)
                throws FormException {
            if (req == null) {
                return new InstantMessageProperty(
                        formData.getString("address"),
                        formData.getString("phone"));
            }
            return new InstantMessageProperty(
                    req.getParameter("qq.address"),
                    req.getParameter("mobile.phone"));
        }
    }
}