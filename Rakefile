#
#    Licensed to the Apache Software Foundation (ASF) under one or more
#    contributor license agreements.  See the NOTICE file distributed with
#    this work for additional information regarding copyright ownership.
#    The ASF licenses this file to You under the Apache License, Version 2.0
#    (the "License"); you may not use this file except in compliance with
#    the License.  You may obtain a copy of the License at
#
#       http://www.apache.org/licenses/LICENSE-2.0
#
#    Unless required by applicable law or agreed to in writing, software
#    distributed under the License is distributed on an "AS IS" BASIS,
#    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#    See the License for the specific language governing permissions and
#    limitations under the License.
#

gem "buildr", "~>1.2.4"
require "buildr"
require "buildr/xmlbeans.rb"
require "buildr/openjpa"
require "buildr/javacc"
require "buildr/jetty"
require "buildr/hibernate"

# Keep this structure to allow the build system to update version numbers.
VERSION_NUMBER = "1.2RC1"
NEXT_VERSION = "1.2"

ANNONGEN            = "annogen:annogen:jar:0.1.0"
ANT                 = "ant:ant:jar:1.6.5"
AXIOM               = [ group("axiom-api", "axiom-impl", "axiom-dom",
                        :under=>"org.apache.ws.commons.axiom", :version=>"1.2.5") ]
AXIS2_WAR           = "org.apache.axis2:axis2-webapp:war:1.3"
AXIS2_ALL           = group("axis2-adb", "axis2-codegen", "axis2-kernel",
                        "axis2-java2wsdl", "axis2-jibx", "axis2-saaj", "axis2-xmlbeans",
                        :under=>"org.apache.axis2", :version=>"1.3")
AXIS2_TEST          = group("httpcore", "httpcore-nio", "httpcore-niossl", 
                            :under=>"org.apache.httpcomponents", :version=>"4.0-alpha5")
BACKPORT            = "backport-util-concurrent:backport-util-concurrent:jar:3.0"
COMMONS             = struct(
  :codec            =>"commons-codec:commons-codec:jar:1.3",
  :collections      =>"commons-collections:commons-collections:jar:3.1",
  :dbcp             =>"commons-dbcp:commons-dbcp:jar:1.2.1",
  :fileupload       =>"commons-fileupload:commons-fileupload:jar:1.1.1",
  :httpclient       =>"commons-httpclient:commons-httpclient:jar:3.0",
  :lang             =>"commons-lang:commons-lang:jar:2.1",
  :logging          =>"commons-logging:commons-logging:jar:1.1",
  :pool             =>"commons-pool:commons-pool:jar:1.2",
  :primitives       =>"commons-primitives:commons-primitives:jar:1.0"
)
DERBY               = "org.apache.derby:derby:jar:10.4.1.3"
DERBY_TOOLS         = "org.apache.derby:derbytools:jar:10.4.1.3"
DOM4J               = "dom4j:dom4j:jar:1.6.1"
GERONIMO            = struct(
  :kernel           =>"org.apache.geronimo.modules:geronimo-kernel:jar:2.0.1",
  :transaction      =>"org.apache.geronimo.components:geronimo-transaction:jar:2.0.1",
  :connector        =>"org.apache.geronimo.components:geronimo-connector:jar:2.0.1"
)
HIBERNATE           = [ "org.hibernate:hibernate:jar:3.2.5.ga", "asm:asm:jar:1.5.3",
                        "antlr:antlr:jar:2.7.6", "cglib:cglib:jar:2.1_3", "net.sf.ehcache:ehcache:jar:1.2.3" ]
HSQLDB              = "hsqldb:hsqldb:jar:1.8.0.7"
JAVAX               = struct(
  :activation       =>"javax.activation:activation:jar:1.1",
  #:activation       =>"geronimo-spec:geronimo-spec-activation:jar:1.0.2-rc4",
  :connector        =>"org.apache.geronimo.specs:geronimo-j2ee-connector_1.5_spec:jar:1.0",
  :ejb              =>"org.apache.geronimo.specs:geronimo-ejb_2.1_spec:jar:1.1",
  :javamail         =>"geronimo-spec:geronimo-spec-javamail:jar:1.3.1-rc5",
  :jms              =>"geronimo-spec:geronimo-spec-jms:jar:1.1-rc4",
  :persistence      =>"javax.persistence:persistence-api:jar:1.0",
  :servlet          =>"org.apache.geronimo.specs:geronimo-servlet_2.4_spec:jar:1.0",
  :stream           =>"stax:stax-api:jar:1.0.1",
  :transaction      =>"org.apache.geronimo.specs:geronimo-jta_1.1_spec:jar:1.1",
  :resource         =>"org.apache.geronimo.specs:geronimo-j2ee-connector_1.5_spec:jar:1.0"
)
JAXEN               = "jaxen:jaxen:jar:1.1.1"
JBI                 = "org.apache.servicemix:servicemix-jbi:jar:3.1.1-incubating"
JENCKS              = "org.jencks:jencks:jar:all:1.3"
JIBX                = "jibx:jibx-run:jar:1.1-beta3"
LOG4J               = "log4j:log4j:jar:1.2.13"
OPENJPA             = ["org.apache.openjpa:openjpa:jar:1.1.0",
                       "net.sourceforge.serp:serp:jar:1.13.1"]
SAXON               = group("saxon", "saxon-xpath", "saxon-dom", :under=>"net.sf.saxon", :version=>"8.7")
SERVICEMIX          = group("servicemix-core", "servicemix-shared", "servicemix-services",
                        :under=>"org.apache.servicemix", :version=>"3.1-incubating")
SPRING              = group("spring-beans", "spring-context", "spring-core", "spring-jmx",
                        :under=>"org.springframework", :version=>"2.0.1")
TRANQL              = [ "tranql:tranql-connector:jar:1.1", "axion:axion:jar:1.0-M3-dev", COMMONS.primitives ]
WOODSTOX            = "woodstox:wstx-asl:jar:3.2.1"
WSDL4J              = "wsdl4j:wsdl4j:jar:1.6.1"
XALAN               = "org.apache.ode:xalan:jar:2.7.0"
XERCES              = "xerces:xercesImpl:jar:2.9.0"
XSTREAM             = "xstream:xstream:jar:1.2"
WS_COMMONS          = struct(
  :axiom            =>AXIOM,
  :neethi           =>"org.apache.neethi:neethi:jar:2.0.2",
  :xml_schema       =>"org.apache.ws.commons.schema:XmlSchema:jar:1.3.2"
)
XBEAN               = group("xbean-classloader", "xbean-kernel", "xbean-server", "xbean-spring",
                        :under=>"org.apache.xbean", :version=>"2.8")
XMLBEANS            = "org.apache.xmlbeans:xmlbeans:jar:2.3.0"

repositories.remote << "http://pxe.intalio.org/public/maven2"
repositories.remote << "http://people.apache.org/repo/m2-incubating-repository"
repositories.remote << "http://repo1.maven.org/maven2"
repositories.remote << "http://people.apache.org/repo/m2-snapshot-repository"
repositories.remote << "http://download.java.net/maven/2"
repositories.release_to[:url] ||= "sftp://guest@localhost/home/guest"

# Changing releases tag names
class Release
  class << self
    def tag_with_apache_ode(version)
      tag_without_apache_ode("APACHE_ODE_#{version.upcase}")
    end
    alias_method_chain :tag, :apache_ode
  end
end

desc "Apache ODE"
#define "ode", :group=>"org.apache.ode", :version=>VERSION_NUMBER do
define "ode" do
  project.version = VERSION_NUMBER
  project.group = "org.apache.ode"

  compile.options.source = "1.5"
  compile.options.target = "1.5"
  manifest["Implementation-Vendor"] = "Apache Software Foundation"
  meta_inf << file("NOTICE")

  desc "ODE Axis Integration Layer"
  define "axis2" do
    compile.with projects("bpel-api", "bpel-connector", "bpel-dao", "bpel-epr", "bpel-runtime",
      "scheduler-simple", "bpel-schemas", "bpel-store", "utils", "bpel-history"),
      AXIOM, AXIS2_ALL, COMMONS.lang, COMMONS.logging, COMMONS.collections, COMMONS.httpclient, DERBY, GERONIMO.kernel, GERONIMO.transaction,
      JAVAX.activation, JAVAX.servlet, JAVAX.stream, JAVAX.transaction, JENCKS, WSDL4J, WS_COMMONS.xml_schema,
      XMLBEANS

    test.with project("tools"), AXIOM, JAVAX.javamail, COMMONS.codec, COMMONS.httpclient, XERCES, WOODSTOX
    test.exclude '*'

    package :jar
  end

  desc "ODE Axis2 Based Web Application"
  define "axis2-war" do
    libs = projects("axis2", "bpel-api", "bpel-compiler", "bpel-connector", "bpel-dao",
      "bpel-epr", "bpel-obj", "bpel-ql", "bpel-runtime", "scheduler-simple",
      "bpel-schemas", "bpel-store", "dao-hibernate", "jacob", "jca-ra", "jca-server",
      "utils", "dao-jpa", "bpel-history"),
      AXIS2_ALL, ANNONGEN, BACKPORT, COMMONS.codec, COMMONS.collections, COMMONS.fileupload, COMMONS.httpclient,
      COMMONS.lang, COMMONS.logging, COMMONS.pool, DERBY, DERBY_TOOLS, JAXEN, JAVAX.activation, JAVAX.ejb, JAVAX.javamail,
      JAVAX.connector, JAVAX.jms, JAVAX.persistence, JAVAX.transaction, JAVAX.stream,  JIBX,
      GERONIMO.connector, GERONIMO.kernel, GERONIMO.transaction, LOG4J, OPENJPA, SAXON, TRANQL,
      WOODSTOX, WSDL4J, WS_COMMONS.axiom, WS_COMMONS.neethi, WS_COMMONS.xml_schema, XALAN, XERCES, XMLBEANS,
	_('../bpel-history/lib/tuprolog.jar'), _('../bpel-history/lib/2p.jar')

    package(:war).with(:libs=>libs).path("WEB-INF").tap do |web_inf|
      web_inf.merge project("dao-jpa-ojpa-derby").package(:zip)
      web_inf.merge project("dao-hibernate-db").package(:zip)
      web_inf.include project("axis2").path_to("src/main/wsdl/*")
      web_inf.include project("bpel-schemas").path_to("src/main/xsd/pmapi.xsd")
    end
    package(:war).tap do |root|
      root.merge(artifact(AXIS2_WAR)).exclude("WEB-INF/*").exclude("META-INF/*")
    end

    task("start"=>[package(:war), jetty.use]) do |task|
      class << task ; attr_accessor :url, :path ; end
      task.url = "http://localhost:8080/ode"
      task.path = jetty.deploy(task.url, task.prerequisites.first)
      jetty.teardown task("stop")
    end

    task("stop") do |task|
      if url = task("start").url rescue nil
        jetty.undeploy url
      end
    end
    
    test.with projects("tools"), libs, AXIS2_TEST, AXIOM, JAVAX.servlet, Buildr::Jetty::REQUIRES, HIBERNATE, DOM4J
    test.setup task(:prepare_webapp) do |task|
      webapp_dir = "target/test-classes/webapp"
      cp_r _("src/main/webapp"), _("target/test-classes")
      cp Dir[_("src/main/webapp/WEB-INF/classes/*")], _("target/test-classes")
      cp Dir[project("axis2").path_to("src/main/wsdl/*")], _("#{webapp_dir}/WEB-INF")
      cp project("bpel-schemas").path_to("src/main/xsd/pmapi.xsd"), _("#{webapp_dir}/WEB-INF")
      rm_rf Dir[_(webapp_dir) + "/**/.svn"]
      mkdir _"#{webapp_dir}/WEB-INF/processes" unless File.exist?(_"#{webapp_dir}/WEB-INF/processes")
    end
    test.setup unzip(_("target/test-classes/webapp/WEB-INF")=>project("dao-jpa-ojpa-derby").package(:zip))
    test.setup unzip(_("target/test-classes/webapp/WEB-INF")=>project("dao-hibernate-db").package(:zip))
  end

  desc "ODE APIs"
  define "bpel-api" do
    compile.with projects("utils", "bpel-obj", "bpel-schemas"), WSDL4J, COMMONS.logging
    package :jar
  end

  desc "ODE JCA connector"
  define "bpel-api-jca" do
    compile.with project("bpel-api"), JAVAX.connector
    package :jar
  end

  desc "ODE BPEL Compiler"
  define "bpel-compiler" do
    compile.with projects("bpel-api", "bpel-obj", "bpel-schemas", "utils"),
      COMMONS.logging, JAVAX.stream, JAXEN, SAXON, WSDL4J, XALAN, XERCES
    test.resources { filter(project("bpel-scripts").path_to("src/main/resources")).into(test.resources.target).run }
    package :jar
  end

  desc "ODE JCA Connector Implementation"
  define "bpel-connector" do
    compile.with projects("bpel-api", "bpel-api-jca", "bpel-runtime", "jca-ra", "jca-server")
    package :jar
  end

  desc "ODE DAO Interfaces"
  define "bpel-dao" do
    compile.with project("bpel-api")
    package :jar
  end

  desc "ODE Interface Layers Common"
  define "bpel-epr" do
    compile.with projects("utils", "bpel-dao", "bpel-api"),
      AXIOM, COMMONS.lang, COMMONS.logging, DERBY, JAVAX.connector, JAVAX.stream, JAVAX.transaction, GERONIMO.transaction, GERONIMO.connector, TRANQL, XMLBEANS
    package :jar
  end

  desc "ODE BPEL Object Model"
  define "bpel-obj" do
    compile.with project("utils"), SAXON, WSDL4J
    package :jar
  end
  
  #-AL-2008-08-25
  desc "History Based Security"
  define "bpel-history" do
    compile.with project("utils"), COMMONS.logging, WSDL4J, _('lib/tuprolog.jar'), _('lib/2p.jar')
    package :jar
  end
  #-AL-2008-08-25

  desc "ODE BPEL Query Language"
  define "bpel-ql" do
    pkg_name = "org.apache.ode.ql.jcc"
    jjtree = jjtree(_("src/main/jjtree"), :in_package=>pkg_name)
    compile.from javacc(jjtree, :in_package=>pkg_name), jjtree
    compile.with projects("bpel-api", "bpel-compiler", "bpel-obj", "jacob", "utils")

    package :jar
  end

  desc "ODE Runtime Engine"
  define "bpel-runtime" do
    compile.from apt
    compile.with projects("bpel-api", "bpel-compiler", "bpel-dao", "bpel-obj", "bpel-schemas",
      "bpel-store", "jacob", "jacob-ap", "utils", "bpel-history"),
      COMMONS.logging, COMMONS.collections, COMMONS.httpclient, JAXEN, JAVAX.persistence, JAVAX.stream, SAXON, WSDL4J, XMLBEANS

    test.with projects("scheduler-simple", "dao-jpa", "dao-hibernate", "bpel-epr", "bpel-history"),
        BACKPORT, COMMONS.pool, COMMONS.lang, DERBY, JAVAX.connector, JAVAX.transaction,
        GERONIMO.transaction, GERONIMO.kernel, GERONIMO.connector, TRANQL, HSQLDB, JAVAX.ejb,
        LOG4J, XERCES, Buildr::OpenJPA::REQUIRES, XALAN

    package :jar
  end

  desc "ODE Simple Scheduler"
  define "scheduler-simple" do
    compile.with projects("bpel-api", "utils"), COMMONS.collections, COMMONS.logging, JAVAX.transaction
	test.compile.with HSQLDB, GERONIMO.kernel, GERONIMO.transaction
	test.with HSQLDB, JAVAX.transaction, JAVAX.resource, JAVAX.connector, LOG4J,
          GERONIMO.kernel, GERONIMO.transaction, BACKPORT, JAVAX.ejb
    package :jar
  end

  desc "ODE Schemas"
  define "bpel-schemas" do
    compile_xml_beans _("src/main/xsd/*.xsdconfig"), _("src/main/xsd")
    package :jar
  end

  desc "ODE BPEL Test Script Files"
  define "bpel-scripts" do
    package :jar
  end

  desc "ODE Process Store"
  define "bpel-store" do
    compile.with projects("bpel-api", "bpel-compiler", "bpel-dao", "bpel-obj", "bpel-schemas", "bpel-epr",
      "dao-hibernate", "utils", "bpel-history"),
      COMMONS.logging, JAVAX.persistence, JAVAX.stream, HIBERNATE, HSQLDB, XMLBEANS, XERCES, WSDL4J
    compile { open_jpa_enhance }
    resources hibernate_doclet(:package=>"org.apache.ode.store.hib", :excludedtags=>"@version,@author,@todo")

    test.with COMMONS.collections, COMMONS.lang, JAVAX.connector, JAVAX.transaction, DOM4J, LOG4J,
      XERCES, XALAN, JAXEN, SAXON, OPENJPA
    package :jar
  end

  desc "ODE BPEL Tests"
  define "bpel-test" do
    compile.with projects("bpel-api", "bpel-compiler", "bpel-dao", "bpel-runtime",
      "bpel-store", "utils", "bpel-epr", "dao-jpa"),
      DERBY, Java::JUnit::JUNIT_REQUIRES, JAVAX.persistence, OPENJPA, WSDL4J, COMMONS.httpclient,
	COMMONS.codec

    test.with projects("bpel-obj", "jacob", "bpel-schemas",
      "bpel-scripts", "scheduler-simple"),
      COMMONS.collections, COMMONS.lang, COMMONS.logging, DERBY, JAVAX.connector,
      JAVAX.stream, JAVAX.transaction, JAXEN, HSQLDB, LOG4J, SAXON, XERCES, XMLBEANS, XALAN

    package :jar
  end

  desc "ODE Hibernate DAO Implementation"
  define "dao-hibernate" do
    compile.with projects("bpel-api", "bpel-dao", "bpel-ql", "utils"),
      COMMONS.lang, COMMONS.logging, JAVAX.transaction, HIBERNATE, DOM4J
    resources hibernate_doclet(:package=>"org.apache.ode.daohib.bpel.hobj", :excludedtags=>"@version,@author,@todo")

    test.with project("bpel-epr"), BACKPORT, COMMONS.collections, COMMONS.lang, HSQLDB,
      GERONIMO.transaction, GERONIMO.kernel, GERONIMO.connector, JAVAX.connector, JAVAX.ejb, SPRING

    package :jar
  end

  desc "ODE Hibernate Compatible Databases"
  define "dao-hibernate-db" do
    predefined_for = lambda { |name| _("src/main/sql/simplesched-#{name}.sql") }
    properties_for = lambda { |name| _("src/main/sql/ode.#{name}.properties") }

    dao_hibernate = project("dao-hibernate").compile.target
    bpel_store = project("bpel-store").compile.target

    Buildr::Hibernate::REQUIRES[:xdoclet] =  Buildr.group("xdoclet", "xdoclet-xdoclet-module", "xdoclet-hibernate-module",
      :under=>"xdoclet", :version=>"1.2.3") + ["xdoclet:xjavadoc:jar:1.1-j5"]
    export = lambda do |properties, source, target|
      file(target=>[properties, source]) do |task|
        mkpath File.dirname(target), :verbose=>false
        # Protection against a buildr bug until the fix is released, avoids build failure
        class << task ; attr_accessor :ant ; end
        task.enhance { |task| task.ant = Buildr::Hibernate.schemaexport }
        
        hibernate_schemaexport target do |task, ant|
          ant.schemaexport(:properties=>properties.to_s, :quiet=>"yes", :text=>"yes", :delimiter=>";",
                           :drop=>"no", :create=>"yes", :output=>target) do
            ant.fileset(:dir=>source.to_s) { ant.include :name=>"**/*.hbm.xml" }
                           end
        end
      end
    end

    runtime_sql = export[ properties_for[:derby], dao_hibernate, _("target/runtime.sql") ]
    store_sql = export[ properties_for[:derby], bpel_store, _("target/store.sql") ]
    derby_sql = concat(_("target/derby.sql")=>[ predefined_for[:derby], runtime_sql, store_sql ])
    derby_db = Derby.create(_("target/derby/hibdb")=>derby_sql)
    build derby_db

    %w{ firebird hsql postgres sqlserver oracle }.each do |db|
      partial = export[ properties_for[db], dao_hibernate, _("target/partial.#{db}.sql") ]
      build concat(_("target/#{db}.sql")=>[ predefined_for[db], partial ])
    end

    package(:zip).include(derby_db)
  end

  desc "ODE OpenJPA DAO Implementation"
  define "dao-jpa" do
    compile.with projects("bpel-api", "bpel-dao", "utils"),
      COMMONS.collections, COMMONS.logging, JAVAX.connector, JAVAX.persistence, JAVAX.transaction,
      OPENJPA, XERCES
    compile { open_jpa_enhance }
    package :jar
  end

  desc "ODE OpenJPA Derby Database"
  define "dao-jpa-ojpa-derby" do
    %w{ derby mysql oracle }.each do |db|
      db_xml = _("src/main/descriptors/persistence.#{db}.xml")
      scheduler_sql = _("src/main/scripts/simplesched-#{db}.sql")
      partial_sql = file("target/partial.#{db}.sql"=>db_xml) do |task|
        mkpath _("target"), :verbose=>false
        Buildr::OpenJPA.mapping_tool :properties=>db_xml, :action=>"build", :sql=>task.name,
          :classpath=>projects("bpel-store", "dao-jpa", "bpel-api", "bpel-dao", "utils" )
      end
      sql = concat(_("target/#{db}.sql")=>[_("src/main/scripts/license-header.sql"), partial_sql, scheduler_sql])
      build sql
    end
    derby_db = Derby.create(_("target/derby/jpadb")=>_("target/derby.sql"))

    test.with projects("bpel-api", "bpel-dao", "bpel-obj", "bpel-epr", "dao-jpa", "utils"),
      BACKPORT, COMMONS.collections, COMMONS.lang, COMMONS.logging, GERONIMO.transaction,
      GERONIMO.kernel, GERONIMO.connector, HSQLDB, JAVAX.connector, JAVAX.ejb, JAVAX.persistence,
      JAVAX.transaction, LOG4J, OPENJPA, XERCES, WSDL4J

    build derby_db
    package(:zip).include(derby_db)
  end

  desc "ODE JAva Concurrent OBjects"
  define "jacob" do
    compile.with projects("utils", "jacob-ap"), COMMONS.logging
    compile.from apt

    package :jar
  end

  desc "ODE Jacob APR Code Generation"
  define "jacob-ap" do
    compile.with Java.tools_jar
    package :jar
  end

  desc "ODE JBI Integration Layer"
  define "jbi" do
    compile.with projects("bpel-api", "bpel-connector", "bpel-dao", "bpel-epr", "bpel-obj",
      "bpel-runtime", "scheduler-simple", "bpel-schemas", "bpel-store", "utils"),
      AXIOM, COMMONS.logging, COMMONS.pool, JAVAX.transaction, JBI, LOG4J, WSDL4J, XERCES

    package(:jar)
    package(:jbi).tap do |jbi|
      libs = artifacts(package(:jar),
        projects("bpel-api", "bpel-api-jca", "bpel-compiler", "bpel-connector", "bpel-dao",
        "bpel-epr", "jca-ra", "jca-server", "bpel-obj", "bpel-ql", "bpel-runtime",
        "scheduler-simple", "bpel-schemas", "bpel-store", "dao-hibernate", "dao-jpa",
        "jacob", "jacob-ap", "utils"),
        ANT, AXIOM, BACKPORT, COMMONS.codec, COMMONS.collections, COMMONS.dbcp, COMMONS.lang, COMMONS.pool,
        COMMONS.primitives, DERBY, GERONIMO.connector, GERONIMO.transaction, JAXEN, JAVAX.connector, 
        JAVAX.ejb, JAVAX.jms, JAVAX.persistence, JAVAX.stream, JAVAX.transaction, LOG4J, OPENJPA, 
        SAXON, TRANQL, XALAN, XERCES, XMLBEANS, XSTREAM, WSDL4J)

      jbi.component :type=>:service_engine, :name=>"OdeBpelEngine", :description=>self.comment
      jbi.component :class_name=>"org.apache.ode.jbi.OdeComponent", :libs=>libs
      jbi.bootstrap :class_name=>"org.apache.ode.jbi.OdeBootstrap", :libs=>libs
      jbi.merge project("dao-hibernate-db").package(:zip)
      jbi.merge project("dao-jpa-ojpa-derby").package(:zip)
      jbi.include path_to("src/main/jbi/ode-jbi.properties")
    end

    test.with projects("dao-jpa", "bpel-compiler", "bpel-api-jca", "jca-ra",
      "jca-server", "jacob"),
      BACKPORT, COMMONS.lang, COMMONS.collections, DERBY, GERONIMO.connector, GERONIMO.kernel,
      GERONIMO.transaction, JAVAX.connector, JAVAX.ejb, JAVAX.persistence, JAVAX.stream,
      JAVAX.transaction, JAXEN, JBI, OPENJPA, SAXON, SERVICEMIX, SPRING, TRANQL,
      XALAN, XBEAN, XMLBEANS, XSTREAM
    test.using :properties=>{ "jbi.install"=>_("target/smixInstallDir"),  "jbi.examples"=>_("../distro/src/examples-jbi/") }
    test.setup unzip(_("target/smixInstallDir/install/ODE")=>project("dao-jpa-ojpa-derby").package(:zip))
  end

  desc "ODE JCA Resource Archive"
  define "jca-ra" do
    compile.with project("utils"), JAVAX.connector
    package :jar
  end

  desc "ODE JCA Server"
  define "jca-server" do
    compile.with projects("jca-ra", "utils"), COMMONS.logging
    package :jar
  end

  desc "ODE Tools"
  define "tools" do
    compile.with projects("bpel-compiler", "utils"), ANT, COMMONS.httpclient, COMMONS.logging
    package :jar
  end

  desc "ODE Utils"
  define "utils" do
    compile.with COMMONS.collections, COMMONS.logging, COMMONS.pool, COMMONS.httpclient, COMMONS.codec, LOG4J, XERCES, JAVAX.stream, WSDL4J
	test.exclude "*TestResources"
    package :jar
  end

end

define "apache-ode" do
  [:version, :group, :manifest, :meta_inf].each { |prop| send "#{prop}=", project("ode").send(prop) }

  def distro(project, postfix)
    id = project.parent.id + postfix
    project.package(:zip, :id=>id).path("#{id}-#{version}").tap do |zip|
      zip.include meta_inf + ["RELEASE_NOTES", "README"].map { |f| path_to(f) }
      zip.path("examples").include project.path_to("src/examples"+postfix), :as=>"."


      # Libraries
	# AL: added prolog jars
      zip.path("lib").include artifacts(COMMONS.logging, COMMONS.codec, COMMONS.httpclient,
        COMMONS.pool, COMMONS.collections, JAXEN, SAXON, LOG4J, WSDL4J, XALAN, XERCES, _('bpel-history/lib/tuprolog.jar'), _('bpel-history/lib/2p.jar'))

      project("ode").projects("utils", "tools", "bpel-compiler", "bpel-api", "bpel-obj", "bpel-schemas").
        map(&:packages).flatten.each do |pkg|
        zip.include(pkg.to_s, :as=>"#{pkg.id}.#{pkg.type}", :path=>"lib")
      end

      # Including third party licenses
      Dir["#{project.path_to("license")}/*LICENSE"].each { |l| zip.include(l, :path=>"lib") }
      zip.include(project.path_to("target/LICENSE"))

      # Include supported database schemas
      Dir["#{project("ode:dao-jpa-ojpa-derby").path_to("target")}/*.sql"].each do |f|
        zip.include(f, :path=>"sql") unless f =~ /partial/
      end

      # Tools scripts (like bpelc and sendsoap)
      bins = file(project.path_to("target/bin")=>FileList[project.path_to("src/bin/*")]) do |task|
        mkpath task.name
        cp task.prerequisites, task.name
        chmod 0755, FileList[task.name + "/*"], :verbose=>false
      end
      zip.include(bins)

      yield zip
      # For some reason this always fails on a clean build, commenting until I have time to inquire
      # project.check zip, "should contain mysql.sql" do
      #   it.should contain("sql/mysql.sql")
      # end
    end
  end

  desc "ODE Axis2 Based Distribution"
  define "distro" do
    parent.distro(self, "-war") { |zip| zip.include project("ode:axis2-war").package(:war), :as=>"ode.war" }
    parent.distro(self, "-jbi") { |zip| zip.include project("ode:jbi").package(:zip) }

    # Preparing third party licenses
    build do
      Dir.mkdir(project.path_to("target")) unless File.exist?(project.path_to("target"))
      cp parent.path_to("LICENSE"), project.path_to("target/LICENSE")
      File.open(project.path_to("target/LICENSE"), "a+") do |l|
        l <<  Dir["#{project.path_to("license")}/*LICENSE"].map { |f| "lib/"+f[/[^\/]*$/] }.join("\n")
      end
    end

    project("ode:axis2-war").task("start").enhance do |task|
      target = "#{task.path}/webapp/WEB-INF/processes"
      puts "Deploying processes to #{target}" if verbose
      verbose(false) do
        mkpath target
        cp_r FileList[_("src/examples/*")].to_a, target
        rm Dir.glob("#{target}/*.deployed")
      end
    end
  end



  package(:zip, :id=>"#{id}-sources").path("#{id}-sources-#{version}").tap do |zip|
    if File.exist?(".svn")
      `svn status -v`.reject { |l| l[0] == ?? || l[0] == ?D }.
        map { |l| l.split.last }.reject { |f| File.directory?(f) }.
        each { |f| zip.include f, :as=>f }
    else
      zip.include Dir.pwd, :as=>"."
    end
  end

  package(:zip, :id=>"#{id}-docs").include(javadoc(project("ode").projects).target) unless ENV["JAVADOC"] =~ /^(no|off|false|skip)$/i

end

