import { AppSidebar } from "@/components/sidebar/appSidebar";
import { SidebarProvider } from "@/components/ui/sidebar";

const AuthLayout = ({ children }: { children: React.ReactNode }) => {
  return (
    <SidebarProvider>
      <AppSidebar />
      <main className="w-full">{children}</main>
    </SidebarProvider>
  );
};

export default AuthLayout;
