<h2><strong>Formate Number LibPhoneNumber </strong></h2>
<p>Goal is to have something as similar to LibPhonenumber to format phone number based on country code</p>
<h2><strong>Requirements</strong></h2>
<p>Android 4.0 or higher&nbsp;</p>
<h2><strong> Usage</strong></h2>
<h4><strong>Step 1.&nbsp;</strong>Add it in your root build.gradle at the end of repositories:</h4>
<pre class="kode language-css code-toolbar"><code class=" kode language-css"><span class="token selector">allprojects</span> <span class="token punctuation">{</span>
		<span class="token selector">repositories</span> <span class="token punctuation">{</span>
			<span class="token selector">...
			maven</span> <span class="token punctuation">{</span> url <span class="token string">'https://jitpack.io'</span> <span class="token punctuation">}</span>
		<span class="token punctuation">}</span>
	<span class="token punctuation">}<br /><br /></span></code></pre>
<p><strong>Step 2.&nbsp;Add the dependency</strong></p>
<pre class="kode code-toolbar  language-css"><code id="depCodeGradle" class=" kode  language-css"><span class="token selector">dependencies</span> <span class="token punctuation">{</span>
	        implementation <span class="token string">'com.github.mammahe:Format-Number-Libphonenumber:0.1.0'</span>
	<span class="token punctuation">}</span></code></pre>
<p><strong>Step 3. Add import in activity</strong></p>
<pre>import com.sairamkrishna.formatnumber.FormatNumber;</pre>
<p><strong>Step 4. Example usage in activity</strong></p>
<pre>hyphen.setText("Hyphen: "+FormatNumber.getFormattedNumber("+919652018244","Hyphen",this));<br />national.setText("National: "+FormatNumber.getFormattedNumber("+919652018244","National",this));<br />international.setText("International: "+FormatNumber.getFormattedNumber("+919652018244","International",this));<br />e164.setText("E164: "+FormatNumber.getFormattedNumber("+919652018244","E164",this));</pre>
<p><strong>Step 5. Detail information about usage</strong></p>
<pre>FormatNumber.getFormattedNumber("+919652018244","Hyphen",this);</pre>
<p>getFormattedNumber required three strings as&nbsp;</p>
<p>1. Phone number included country code as +1.</p>
<p>2. Which format needed to get out put. There are four formats are available as <strong>HYPHEN, NATIONAL,INTERNATIONAL, E164</strong>.<strong>&nbsp;</strong></p>
<p>3. Context of an activity (default string is <strong>this</strong>).</p>
<h2>Output</h2>
<p><img style="display: block; margin-left: auto; margin-right: auto;" src="https://user-images.githubusercontent.com/39652440/61815603-3f19d480-ae68-11e9-8360-4e2aeb276823.png" alt="" width="350" height="700" /></p>
<h2>License</h2>
<p>Copyright 2019 Sairamkrishna Mammahe</p>
<p>Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at</p>
<p>http://www.apache.org/licenses/LICENSE-2.0</p>
<p>Unless required by applicable law or agreed to in writing, software under the License is distributed on an "AS IS" BASIS, WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. the License for the specific language governing permissions and under the License.</p>
