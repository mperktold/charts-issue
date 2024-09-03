# Reproducer for Issue with ChartOptions

This repository reproduces a Reference Error on the client side that happens when `ChartOptions` are changed after `Chart.redraw` has been called with `true`.
The error looks like this:

```
vaadin.js?v=ca80360c:94687 Uncaught (in promise) TypeError: Cannot read properties of undefined (reading 'redraw')
    at vaadin.js?v=ca80360c:94687:126
    at Array.forEach (<anonymous>)
    at Chart.__callHighchartsFunction (vaadin.js?v=ca80360c:94687:109)
    at HTMLBodyElement.eval (eval at Qt (FlowClient.js:1044:101), <anonymous>:3:63)
    at Object.eval (eval at Qt (FlowClient.js:1044:101), <anonymous>:3:110)
    at Qt (FlowClient.js:1044:166)
    at Pt (FlowClient.js:995:277)
    at Nt (FlowClient.js:614:57)
    at rr (FlowClient.js:459:18)
    at Nr.Or [as eb] (FlowClient.js:1053:19940)
    at vB (FlowClient.js:964:221)
    at ur (FlowClient.js:1048:296)
    at Jr.Kr [as C] (FlowClient.js:1053:19706)
    at Qk (FlowClient.js:441:29)
    at mr (FlowClient.js:1051:1411)
    at nr (FlowClient.js:1034:403)
    at Ct.Et [as mb] (FlowClient.js:1053:23174)
    at VB.WB [as J] (FlowClient.js:1053:36239)
    at XMLHttpRequest.<anonymous> (FlowClient.js:631:63)
    at Eb (FlowClient.js:450:29)
    at Hb (FlowClient.js:920:56)
    at XMLHttpRequest.<anonymous> (FlowClient.js:650:46)
```

To reproduce, follow the following steps:
1. Start the application (see instructions below).
2. Open the browser at http://localhost:8080.
3. Open DevTools.
4. In the Dashboard view, click on the update button.
5. Navigate to "Other view".
6. Navigate back to "Dashboard".
7. You should now see the error in the console.

## Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

You can also import the project to your IDE of choice as you would with any
Maven project.

## Deploying to Production

To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `./mvnw clean package -Pproduction` (Mac & Linux).
This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/myapp-1.0-SNAPSHOT.jar` (NOTE, replace
`myapp-1.0-SNAPSHOT.jar` with the name of your jar).

## Project structure

<table style="width:100%; text-align: left;">
  <tr><th>Directory</th><th>Description</th></tr>
  <tr><td><code>src/main/frontend/</code></td><td>Client-side source directory</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>index.html</code></td><td>HTML template</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>index.ts</code></td><td>Frontend 
entrypoint, bootstraps a React application</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>routes.tsx</code></td><td>React Router routes definition</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>MainLayout.tsx</code></td><td>Main 
layout component, contains the navigation menu, uses <a href="https://hilla.dev/docs/react/components/app-layout">
App Layout</a></td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>views/</code></td><td>UI view 
components</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>themes/</code></td><td>Custom  
CSS styles</td></tr>
  <tr><td><code>src/main/java/&lt;groupId&gt;/</code></td><td>Server-side 
source directory, contains the server-side Java views</td></tr>
  <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;<code>Application.java</code></td><td>Server entry-point</td></tr>
</table>

## Useful links

- Read the documentation at [hilla.dev/docs](https://hilla.dev/docs/).
- Ask questions on [Stack Overflow](https://stackoverflow.com/questions/tagged/hilla) or join our [Discord channel](https://discord.gg/MYFq5RTbBn).
- Report issues, create pull requests in [GitHub](https://github.com/vaadin/hilla).
