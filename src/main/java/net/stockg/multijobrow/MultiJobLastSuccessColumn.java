/*
 * The MIT License
 *
 * Copyright 2015 gstockfisch.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.stockg.multijobrow;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.model.Job;
import hudson.model.Run;
import hudson.scm.NullSCM;
import hudson.scm.SCM;
import hudson.triggers.SCMTrigger;
import hudson.triggers.TimerTrigger;
import hudson.triggers.Trigger;
import hudson.triggers.TriggerDescriptor;
import hudson.views.ListViewColumn;
import hudson.views.ListViewColumnDescriptor;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jenkins.model.Jenkins;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.export.Exported;

/**
 *
 * @author gstockfisch
 */
public class MultiJobLastSuccessColumn extends ListViewColumn{
    

    public static Logger LOGGER = Logger.getLogger(MultiJobLastSuccessColumn.class.getSimpleName());
	
	
    public String getMultiJobs(Job job){
       
    	return "multiJOBBBBB";
    }
    @Extension
    public static final class DescriptorImpl extends ListViewColumnDescriptor {
        @Override
        public ListViewColumn newInstance(StaplerRequest req, JSONObject formData){
        	return new MultiJobLastSuccessColumn();
        }
        
		@Override
		public String getDisplayName(){
			return "Downstream Job Last Success";
		}
        
        @Override
        public boolean shownByDefault() {
            return false;
        }
    }

}
