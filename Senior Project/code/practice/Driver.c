#include <ntddk.h> //contains core Windows kernel definitions for all drivers
#include <wdf.h> //contains definitions for drivers based on the WDF (w driver framework)

/*
 Tutorial Website: https://docs.microsoft.com/en-us/windows-hardware/drivers/gettingstarted/writing-a-very-small-kmdf--driver
*/
//declerations for two callbacks
DRIVER_INITIALIZE DriverEntry;
EVT_WDF_DRIVER_DEVICE_ADD KmdfHelloWorldEvtDeviceAdd;

//Driver Entry Code
/*
* DriverEntry is the entry point for all drivers (like Main() for many other programs).
* The job of DriverEntry is to initalize driver-wide structures and resources.
* In this program we print "Hello World" for DriverEntry, configure the driver object to register the
* EvtDeviceAdd callback's entry point, then create the driver objecct and returned.
*/
NTSTATUS
DriverEntry(
	_In_ PDRIVER_OBJECT    DriverObject,
	_In_ PUNICODE_STRING   RegistryPath
)
{
	//NTSTATUS variable to record success or failure
	NTSTATUS status = STATUS_SUCCESS;

	//Allocate the driver configuration object
	WDF_DRIVER_CONFIG config;

	//Print "Hello World" for DriverEntry
	KdPrintEx(( DPFLTR_IHVDRIVER_ID, DPFLTR_INFO_LEVEL, "KmdfHelloWorld: DriverEntry\n"));

	//Initialize the dirver configuration objecct to register the entry point for the
	//EvtDeviceAdd callback, KmdfHelloWorldEvtDeviceAdd
	WDF_DRIVER_CONFIG_INIT(&config, KmdfHelloWorldEvtDeviceAdd);

	//Finally, create the driver object
	status = WdfDriverCreate(DriverObject, RegistryPath, WDF_NO_OBJECT_ATTRIBUTES, &config, WDF_NO_HANDLE);

	return status;
}

/*
* EvtDeviceAdd is invoked by the system when it detects that your device has arrived. It's job is to
* initialize structures and resources for that device.
* In this project "Hello World" is printed out as a message for EvtDeviceAdd, create the device object,
* and then returned. 
* 
* In other drivers you write, you might create I/O queues for your hardware, setup a device context storage
* space for device-specific information, or perform other tasks needed to prepare your device
* 
* NOTE: Generally for the device add callback, the driver's functions have the project's name as a prefix
* in order to differentiate from other driver's functions. DriverEntry is the only one that should be named
* exactly that.
*/
NTSTATUS
KmdfHelloWorldEvtDeviceAdd(
	_In_ WDFDRIVER Driver,
	_Inout_ PWDFDEVICE_INIT DeviceInit
)
{
	//We're not using the driver object,
	//so we need to mark it as unreferenced
	UNREFERENCED_PARAMETER(Driver);

	NTSTATUS status;

	//Allocate the device object
	WDFDEVICE hDevice;

	//Print "Hello World"
	KdPrintEx((DPFLTR_IHVDRIVER_ID, DPFLTR_INFO_LEVEL, "KmdfHelloWorld: KmdfHelloWorldEvtDeviceAdd\n"));

	//Create the device object
	status = WdfDeviceCreate(&DeviceInit, WDF_NO_OBJECT_ATTRIBUTES, &hDevice);

	return status;
}

/*
* Fundamental concept to drivers --> they are a "collection of callbacks" that once initialized, sit
* and wait for the system to call them when it needs something. This could be a new device arrival event,
* an I/O request from a user mode application, a system power shutdown event, a request from another driver,
* or a surprise removal event when a user unplugs the device unexpectedly. 
*/

/*
* Building the Driver 

    1. In the Solution Explorer window, select and hold (or right-click) Solution 'KmdfHelloWorld' (1 project) and choose Configuration Manager. Choose a configuration and platform for the driver project. For this exercise, we choose Debug and x64.

    2. In the Solution Explorer window, select and hold (or right-click) KmdfHelloWorld and choose Properties. In Wpp Tracing > All Options, set Run Wpp tracing to No. Select Apply and then OK.

    3. To build your driver, choose Build Solution from the Build menu. Visual Studio shows the build progress in the Output window. (If the Output window is not visible, choose Output from the View menu.) When you have verified that the solution built successfully, you can close Visual Studio.

    4. To see the built driver, in File Explorer, go to your KmdfHelloWorld folder, and then to C:\KmdfHelloWorld\x64\Debug\KmdfHelloWorld. The folder includes:
        KmdfHelloWorld.sys -- the kernel-mode driver file
        KmdfHelloWorld.inf -- an information file that Windows uses when you install the driver
        KmdfHelloWorld.cat -- a catalog file that the installer uses to verify the driver's test signature

	TIP: If you see DriverVer set to a date in the future when building your driver, change your driver
	project settings so that Inf2Cat sets /uselocaltime. To do so, use 
	Configuration Properties->Inf2Cat->General->Use Local Time. 
	Now both Stampinf and Inf2Cat use local time.
*/

/*
* Deploy the Driver
  Here's a guide on preparing a computer for testing: https://docs.microsoft.com/en-us/windows-hardware/drivers/gettingstarted/provision-a-target-computer-wdk-8-1
*/

